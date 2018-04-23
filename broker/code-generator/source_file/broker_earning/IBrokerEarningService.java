
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-30 09:27:37
*/
public interface IBrokerEarningService {

    /**
     * 新增
     * @param brokerEarning
     * @return
     * @throws Exception
     */
    public void insertBrokerEarning(BrokerEarning brokerEarning) throws Exception;

    /**
     * 根据id修改
     * @param brokerEarning
     * @return
     * @throws Exception
     */
    public void updateBrokerEarningById(BrokerEarning brokerEarning) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteBrokerEarning(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public BrokerEarning queryBrokerEarningById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<BrokerEarning> queryBrokerEarningList(Map<String, Object> map) throws Exception;

}
