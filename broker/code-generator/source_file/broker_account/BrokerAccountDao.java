
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-03-30 11:04:27
 */
@Repository
public interface BrokerAccountDao {

    /**
     * 新增
     * @param brokerAccount
     * @return
     */
    public void insertBrokerAccount(BrokerAccount brokerAccount);

    /**
     * 根据id修改
     * @param brokerAccount
     * @return
     */
    public void updateBrokerAccountById(BrokerAccount brokerAccount);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteBrokerAccount(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return BrokerAccount
     */
    public BrokerAccount queryBrokerAccountById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<BrokerAccount>
     */
    public List<BrokerAccount> queryBrokerAccountList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<BrokerAccount>
     */
    public List<BrokerAccount> queryBrokerAccountPageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer queryBrokerAccountPageCount(Map<String, Object> map);
}
