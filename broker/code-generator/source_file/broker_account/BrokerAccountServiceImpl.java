
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-30 14:45:12
*/
@Service
public class BrokerAccountServiceImpl implements IBrokerAccountService{

    @Autowired
    private BrokerAccountDao brokerAccountDao;

    /**
     * 新增
     * @param brokerAccount
     * @return
     * @throws Exception
     */
    public void insertBrokerAccount(BrokerAccount brokerAccount) throws Exception{
        brokerAccountDao.insertBrokerAccount(brokerAccount);
    }

    /**
     * 根据id修改
     * @param brokerAccount
     * @return
     * @throws Exception
     */
    public void updateBrokerAccountById(BrokerAccount brokerAccount) throws Exception{
        if(null == brokerAccount || null == brokerAccount.getUid()) throw new CustomException("参数检验有误");
        brokerAccountDao.updateBrokerAccountById(brokerAccount);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteBrokerAccount(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        brokerAccountDao.deleteBrokerAccount(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public BrokerAccount queryBrokerAccountById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return brokerAccountDao.queryBrokerAccountById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<BrokerAccount> queryBrokerAccountList(Map<String, Object> map) throws Exception{
        return brokerAccountDao.queryBrokerAccountList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<BrokerAccount> queryBrokerAccountPageList(Map<String, Object> map) throws Exception{
        return brokerAccountDao.queryBrokerAccountPageList(map);
    }
}
