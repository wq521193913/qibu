
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-26 15:00:17
*/
public interface IDbOrderReserverService {

    /**
     * 新增
     * @param dbOrderReserver
     * @return
     * @throws Exception
     */
    public void insertDbOrderReserver(DbOrderReserver dbOrderReserver) throws Exception;

    /**
     * 根据id修改
     * @param dbOrderReserver
     * @return
     * @throws Exception
     */
    public void updateDbOrderReserverById(DbOrderReserver dbOrderReserver) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteDbOrderReserver(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public DbOrderReserver queryDbOrderReserverById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<DbOrderReserver> queryDbOrderReserverList(Map<String, Object> map) throws Exception;

}
