
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-26 15:00:18
*/
@Service
public class DbOrderQueueServiceImpl implements IDbOrderQueueService{

    @Autowired
    private DbOrderQueueDao dbOrderQueueDao;

    /**
     * 新增
     * @param dbOrderQueue
     * @return
     * @throws Exception
     */
    public void insertDbOrderQueue(DbOrderQueue dbOrderQueue) throws Exception{
        dbOrderQueueDao.insertDbOrderQueue(dbOrderQueue);
    }

    /**
     * 根据id修改
     * @param dbOrderQueue
     * @return
     * @throws Exception
     */
    public void updateDbOrderQueueById(DbOrderQueue dbOrderQueue) throws Exception{
        if(null == dbOrderQueue || null == dbOrderQueue.getUid()) throw new CustomException("参数检验有误");
        dbOrderQueueDao.updateDbOrderQueueById(dbOrderQueue);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteDbOrderQueue(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        dbOrderQueueDao.deleteDbOrderQueue(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public DbOrderQueue queryDbOrderQueueById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return dbOrderQueueDao.queryDbOrderQueueById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<DbOrderQueue> queryDbOrderQueueList(Map<String, Object> map) throws Exception{
        return dbOrderQueueDao.queryDbOrderQueueList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<DbOrderQueue> queryDbOrderQueuePageList(Map<String, Object> map) throws Exception{
        return dbOrderQueueDao.queryDbOrderQueuePageList(map);
    }
}
