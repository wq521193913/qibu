
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-03-26 15:00:17
 */
@Repository
public interface DbOrderReserverDao {

    /**
     * 新增
     * @param dbOrderReserver
     * @return
     */
    public void insertDbOrderReserver(DbOrderReserver dbOrderReserver);

    /**
     * 根据id修改
     * @param dbOrderReserver
     * @return
     */
    public void updateDbOrderReserverById(DbOrderReserver dbOrderReserver);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteDbOrderReserver(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return DbOrderReserver
     */
    public DbOrderReserver queryDbOrderReserverById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<DbOrderReserver>
     */
    public List<DbOrderReserver> queryDbOrderReserverList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<DbOrderReserver>
     */
    public List<DbOrderReserver> queryDbOrderReserverPageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer queryDbOrderReserverPageCount(Map<String, Object> map);
}
