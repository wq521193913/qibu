
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-03-26 15:00:18
 */
@Repository
public interface DbOrderQueueDao {

    /**
     * 新增
     * @param dbOrderQueue
     * @return
     */
    public void insertDbOrderQueue(DbOrderQueue dbOrderQueue);

    /**
     * 根据id修改
     * @param dbOrderQueue
     * @return
     */
    public void updateDbOrderQueueById(DbOrderQueue dbOrderQueue);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteDbOrderQueue(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return DbOrderQueue
     */
    public DbOrderQueue queryDbOrderQueueById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<DbOrderQueue>
     */
    public List<DbOrderQueue> queryDbOrderQueueList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<DbOrderQueue>
     */
    public List<DbOrderQueue> queryDbOrderQueuePageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer queryDbOrderQueuePageCount(Map<String, Object> map);
}
