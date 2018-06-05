package com.broker.service.impl;

import com.broker.constant.EarningSouceTemplate;
import com.broker.dao.CustomerDao;
import com.broker.domain.BrokerAccount;
import com.broker.domain.BrokerEarning;
import com.broker.domain.Customer;
import com.broker.domain.InviteFriend;
import com.broker.enumerate.BrokerEarningStatus;
import com.broker.enumerate.CustomerAuditEnums;
import com.broker.service.IBrokerAccountService;
import com.broker.service.IBrokerEarningService;
import com.broker.service.ICustomerService;
import com.broker.service.IInviteFriendService;
import com.broker.util.CustomException;
import com.broker.util.MyStringUtils;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Administrator
 * @description:
 * @date: Create in 2018/3/17 0017 上午 11:23
 * @modified:
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    CustomerDao customerDao;
    @Autowired
    private IBrokerEarningService brokerEarningService;
    @Autowired
    private IBrokerAccountService brokerAccountService;
    @Autowired
    private IInviteFriendService iInviteFriendService;

    @Override
    public void insertCustomer(Customer customer)  throws CustomException {
        if(null == customer){
            throw new CustomException("参数检验有误:null");
        }

        if(StringUtils.isEmpty(customer.getCustomerPhone())){
            throw new CustomException("请输入客户电话");
        }

        Customer customer1 = customerDao.getCustomerByPhone(customer.getCustomerPhone());
        if(null != customer1){
            throw new CustomException("此手机号的客户已被登记");
        }

        customer.setAddressDetail(MyStringUtils.nullConvertEmpty(customer.getProvince()) +
                MyStringUtils.nullConvertEmpty(customer.getCity()) +
                MyStringUtils.nullConvertEmpty(customer.getDistrict()) +
                MyStringUtils.nullConvertEmpty(customer.getAddress()));
        customerDao.insertCustomer(customer);
    }

    @Override
    public int deleteCustomerById(int uid) {
        return 0;
    }

    @Override
    public int updateCustomerById(Customer customer) {
        return 0;
    }

    @Override
    public Customer queryCustomerById(int uid) {
        return null;
    }

    @Override
    public List<Customer> queryCustomerList(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<Customer> customerPageList(Map<String, Object> map) {
        return customerDao.customerPageList(map);
    }

    @Override
    public int customerPageCount(Map<String, Object> map) {
        return customerDao.customerPageCount(map);

    }

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    @Override
    public boolean auditCustomer(Integer id, CustomerAuditEnums customerAuditEnums, String auditRemarks) throws Exception{
        if(null == id) {
            throw new CustomException("参数检验有误:id is null");
        }

        Customer customer = customerDao.queryCustomerById(id);
        if(null == customer) throw new CustomException("无法查询到此数据");
        if(null != customer.getAudit() && customer.getAudit() >= customerAuditEnums.getIndex()){
            throw new CustomException("状态不能后退");
        }
        BrokerEarning brokerEarning = null;
        Map<String, Object> map = null;
        int brokerUserId = customer.getBrokerUser();
        int customerId = customer.getUid();
        switch (customerAuditEnums){
            case STATUS_WAIT:
                //待审核
                break;
            case STATUS_UNDER_WAY:
                //装修中
                //给经济人新增收益
                brokerEarning = new BrokerEarning();
                brokerEarning.setBrokerUser(brokerUserId);
                brokerEarning.setEarningAmount(BigDecimal.valueOf(1000));
                brokerEarning.setEarningSource(String.format(EarningSouceTemplate.ESource_DUE_Customer,customer.getCustomerName(),brokerEarning.getEarningAmount()));
                brokerEarning.setStatus(0);
                brokerEarning.setSourceId(customerId);
                brokerEarning.setSourceType(0);
                brokerEarningService.insertBrokerEarning(brokerEarning);
                //邀请奖励
                this.earningInvited(brokerUserId, customerId, 0);
                break;
            case STATUS_COMPLETE:
                //装修完成
                map = new HashMap<String, Object>(8);
                map.put("sourceType",0);
                map.put("sourceId", customerId);
                map.put("brokerUser", brokerUserId);
                brokerEarning = brokerEarningService.queryBrokerEarning(map);
                if(null == brokerEarning){
                    //如果直接点装修完工
                    brokerEarning = new BrokerEarning();
                    brokerEarning.setBrokerUser(brokerUserId);
                    brokerEarning.setEarningAmount(BigDecimal.valueOf(1000));
                    brokerEarning.setEarningSource(String.format(EarningSouceTemplate.ESource_EARN_Customer,customer.getCustomerName(),brokerEarning.getEarningAmount()));
                    brokerEarning.setStatus(1);
                    brokerEarning.setSourceId(customerId);
                    brokerEarning.setSourceType(0);
                    brokerEarningService.insertBrokerEarning(brokerEarning);
                }else {
                    brokerEarning.setStatus(1);
                    brokerEarning.setEarningSource(String.format(EarningSouceTemplate.ESource_EARN_Customer,customer.getCustomerName(),brokerEarning.getEarningAmount()));
                    brokerEarningService.updateBrokerEarningById(brokerEarning);
                }
                //邀请奖励
                this.earningInvited(brokerUserId, customerId, 1);

                //更新用户账户余额
                BrokerAccount brokerAccount = brokerAccountService.brokerAccountByUser(brokerUserId);
                if(null == brokerAccount){
                    brokerAccount = new BrokerAccount();
                    brokerAccount.setBrokerUser(brokerUserId);
                    brokerAccount.setAccountBalance(brokerEarning.getEarningAmount());
                    brokerAccountService.insertBrokerAccount(brokerAccount);
                }else {
                    brokerAccount.setBrokerUser(brokerUserId);
                    brokerAccount.setAccountBalance(brokerAccount.getAccountBalance().add(brokerEarning.getEarningAmount()));
                    brokerAccountService.updateBrokerAccountById(brokerAccount);
                }
                //TODO 发送短信
                break;
            case STATUS_FAIL:
                //洽谈失败
                map = new HashMap<String, Object>(8);
                map.put("sourceType",0);
                map.put("sourceId", customerId);
                map.put("brokerUser", brokerUserId);
                brokerEarning = brokerEarningService.queryBrokerEarning(map);
                if(null == brokerEarning){
                    throw new CustomException("无法查询到经济人待收益数据");
                }
                brokerEarning.setStatus(BrokerEarningStatus.STATUS_LOSE.getIndex());
                brokerEarningService.updateBrokerEarningById(brokerEarning);
                //TODO 发送短信
                break;
        }
        customer.setAudit(customerAuditEnums.getIndex());
        customerDao.updateCustomerById(customer);

        return true;
    }

    /**
     * 给邀请人发奖励
     * @param brokerUserId
     * @param customerId
     * @param status
     * @throws Exception
     */
    private void earningInvited(int brokerUserId, int customerId, int status) throws Exception{
        int count = customerDao.getCompleteCount(brokerUserId);
        if(count == 0){
            InviteFriend inviteFriend = iInviteFriendService.getInviteFriendByInv(brokerUserId);

            if(null != inviteFriend){
                int inviteBrokerId = inviteFriend.getBrokerUser();
                Map<String, Object> map = Maps.newHashMap();
                map.put("sourceType",1);
                map.put("sourceId", customerId);
                map.put("brokerUser", inviteBrokerId);
                BrokerEarning inviteEarning = brokerEarningService.queryBrokerEarning(map);
                if(null == inviteEarning){
                    inviteEarning = new BrokerEarning();
                    inviteEarning.setBrokerUser(inviteBrokerId);
                    inviteEarning.setEarningAmount(BigDecimal.valueOf(100));
                    inviteEarning.setEarningSource("邀请的好友成功接单奖励");
                    inviteEarning.setStatus(status);
                    inviteEarning.setSourceId(customerId);
                    inviteEarning.setSourceType(1);
                    brokerEarningService.insertBrokerEarning(inviteEarning);
                }else {
                    if(status == 1){
                        inviteEarning.setStatus(status);
                        brokerEarningService.updateBrokerEarningById(inviteEarning);
                    }
                }

                if(status == 1){
                    //状态是已发放,更新用户账户余额
                    BrokerAccount brokerAccount = brokerAccountService.brokerAccountByUser(inviteBrokerId);
                    if(null == brokerAccount){
                        brokerAccount = new BrokerAccount();
                        brokerAccount.setBrokerUser(brokerUserId);
                        brokerAccount.setAccountBalance(BigDecimal.valueOf(100));
                        brokerAccountService.insertBrokerAccount(brokerAccount);
                    }else {
                        brokerAccount.setBrokerUser(inviteBrokerId);
                        brokerAccount.setAccountBalance(brokerAccount.getAccountBalance().add(BigDecimal.valueOf(100)));
                        brokerAccountService.updateBrokerAccountById(brokerAccount);
                    }
                }
            }
        }

    }
}
