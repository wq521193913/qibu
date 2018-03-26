
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-26 15:00:17
*/
@Service
public class DbOrderReserverServiceImpl implements IDbOrderReserverService{

    @Autowired
    private DbOrderReserverDao dbOrderReserverDao;

    /**
     * 新增
     * @param dbOrderReserver
     * @return
     * @throws Exception
     */
    public void insertDbOrderReserver(DbOrderReserver dbOrderReserver) throws Exception{
        dbOrderReserverDao.insertDbOrderReserver(dbOrderReserver);
    }

    /**
     * 根据id修改
     * @param dbOrderReserver
     * @return
     * @throws Exception
     */
    public void updateDbOrderReserverById(DbOrderReserver dbOrderReserver) throws Exception{
        if(null == dbOrderReserver || null == dbOrderReserver.getUid()) throw new CustomException("参数检验有误");
        dbOrderReserverDao.updateDbOrderReserverById(dbOrderReserver);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteDbOrderReserver(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        dbOrderReserverDao.deleteDbOrderReserver(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public DbOrderReserver queryDbOrderReserverById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return dbOrderReserverDao.queryDbOrderReserverById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<DbOrderReserver> queryDbOrderReserverList(Map<String, Object> map) throws Exception{
        return dbOrderReserverDao.queryDbOrderReserverList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<DbOrderReserver> queryDbOrderReserverPageList(Map<String, Object> map) throws Exception{
        return dbOrderReserverDao.queryDbOrderReserverPageList(map);
    }
}
