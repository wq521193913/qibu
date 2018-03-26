
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-26 15:00:18
*/
public interface IDbOrderQueueService {

    /**
     * 新增
     * @param dbOrderQueue
     * @return
     * @throws Exception
     */
    public void insertDbOrderQueue(DbOrderQueue dbOrderQueue) throws Exception;

    /**
     * 根据id修改
     * @param dbOrderQueue
     * @return
     * @throws Exception
     */
    public void updateDbOrderQueueById(DbOrderQueue dbOrderQueue) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteDbOrderQueue(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public DbOrderQueue queryDbOrderQueueById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<DbOrderQueue> queryDbOrderQueueList(Map<String, Object> map) throws Exception;

}
