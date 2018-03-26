
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-03-26 15:00:18
 */
@Repository
public interface DbAdvertorialDao {

    /**
     * 新增
     * @param dbAdvertorial
     * @return
     */
    public void insertDbAdvertorial(DbAdvertorial dbAdvertorial);

    /**
     * 根据id修改
     * @param dbAdvertorial
     * @return
     */
    public void updateDbAdvertorialById(DbAdvertorial dbAdvertorial);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteDbAdvertorial(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return DbAdvertorial
     */
    public DbAdvertorial queryDbAdvertorialById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<DbAdvertorial>
     */
    public List<DbAdvertorial> queryDbAdvertorialList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<DbAdvertorial>
     */
    public List<DbAdvertorial> queryDbAdvertorialPageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer queryDbAdvertorialPageCount(Map<String, Object> map);
}
