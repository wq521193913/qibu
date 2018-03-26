
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
public class DbAdvertorialServiceImpl implements IDbAdvertorialService{

    @Autowired
    private DbAdvertorialDao dbAdvertorialDao;

    /**
     * 新增
     * @param dbAdvertorial
     * @return
     * @throws Exception
     */
    public void insertDbAdvertorial(DbAdvertorial dbAdvertorial) throws Exception{
        dbAdvertorialDao.insertDbAdvertorial(dbAdvertorial);
    }

    /**
     * 根据id修改
     * @param dbAdvertorial
     * @return
     * @throws Exception
     */
    public void updateDbAdvertorialById(DbAdvertorial dbAdvertorial) throws Exception{
        if(null == dbAdvertorial || null == dbAdvertorial.getUid()) throw new CustomException("参数检验有误");
        dbAdvertorialDao.updateDbAdvertorialById(dbAdvertorial);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteDbAdvertorial(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        dbAdvertorialDao.deleteDbAdvertorial(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public DbAdvertorial queryDbAdvertorialById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return dbAdvertorialDao.queryDbAdvertorialById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<DbAdvertorial> queryDbAdvertorialList(Map<String, Object> map) throws Exception{
        return dbAdvertorialDao.queryDbAdvertorialList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<DbAdvertorial> queryDbAdvertorialPageList(Map<String, Object> map) throws Exception{
        return dbAdvertorialDao.queryDbAdvertorialPageList(map);
    }
}
