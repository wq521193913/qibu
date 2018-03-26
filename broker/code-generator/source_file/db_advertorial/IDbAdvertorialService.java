
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-26 15:00:18
*/
public interface IDbAdvertorialService {

    /**
     * 新增
     * @param dbAdvertorial
     * @return
     * @throws Exception
     */
    public void insertDbAdvertorial(DbAdvertorial dbAdvertorial) throws Exception;

    /**
     * 根据id修改
     * @param dbAdvertorial
     * @return
     * @throws Exception
     */
    public void updateDbAdvertorialById(DbAdvertorial dbAdvertorial) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteDbAdvertorial(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public DbAdvertorial queryDbAdvertorialById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<DbAdvertorial> queryDbAdvertorialList(Map<String, Object> map) throws Exception;

}
