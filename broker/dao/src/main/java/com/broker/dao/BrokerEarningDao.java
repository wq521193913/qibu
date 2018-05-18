package com.broker.dao;

import com.broker.domain.BrokerEarning;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-03-30 09:27:37
 */
@Repository
public interface BrokerEarningDao {

    /**
     * 新增
     * @param brokerEarning
     * @return
     */
    public void insertBrokerEarning(BrokerEarning brokerEarning);

    /**
     * 根据id修改
     * @param brokerEarning
     * @return
     */
    public void updateBrokerEarningById(BrokerEarning brokerEarning);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteBrokerEarning(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return BrokerEarning
     */
    public BrokerEarning queryBrokerEarningById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<BrokerEarning>
     */
    public List<BrokerEarning> queryBrokerEarningList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<BrokerEarning>
     */
    public List<BrokerEarning> queryBrokerEarningPageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer queryBrokerEarningPageCount(Map<String, Object> map);

    /**
     * 查询 只会取limit 1
     * @param map
     * @return
     */
    BrokerEarning queryBrokerEarning(Map<String, Object> map);

    /**
     * 分页列表
     * @param map
     * @return
     */
    List<BrokerEarning> getEarningPageList(Map<String, Object> map);
    /**
     * 分页列表条数
     * @param map
     * @return
     */
    int getEarningPageCount(Map<String, Object> map);
}
