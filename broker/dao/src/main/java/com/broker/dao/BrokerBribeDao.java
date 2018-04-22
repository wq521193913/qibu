package com.broker.dao;

import com.broker.domain.BrokerBribe;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-03-30 11:04:27
 */
@Repository
public interface BrokerBribeDao {

    /**
     * 新增
     * @param brokerBribe
     * @return
     */
    public void insertBrokerBribe(BrokerBribe brokerBribe);

    /**
     * 根据id修改
     * @param brokerBribe
     * @return
     */
    public void updateBrokerBribeById(BrokerBribe brokerBribe);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteBrokerBribe(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return BrokerBribe
     */
    public BrokerBribe queryBrokerBribeById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<BrokerBribe>
     */
    public List<BrokerBribe> queryBrokerBribeList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<BrokerBribe>
     */
    public List<BrokerBribe> queryBrokerBribePageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer queryBrokerBribePageCount(Map<String, Object> map);
}
