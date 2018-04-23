
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-03-30 14:45:12
 */
@Repository
public interface BrokerActivityDao {

    /**
     * 新增
     * @param brokerActivity
     * @return
     */
    public void insertBrokerActivity(BrokerActivity brokerActivity);

    /**
     * 根据id修改
     * @param brokerActivity
     * @return
     */
    public void updateBrokerActivityById(BrokerActivity brokerActivity);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteBrokerActivity(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return BrokerActivity
     */
    public BrokerActivity queryBrokerActivityById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<BrokerActivity>
     */
    public List<BrokerActivity> queryBrokerActivityList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<BrokerActivity>
     */
    public List<BrokerActivity> queryBrokerActivityPageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer queryBrokerActivityPageCount(Map<String, Object> map);
}
