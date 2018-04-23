
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-04-18 18:07:56
 */
@Repository
public interface GrPayRequestDao {

    /**
     * 新增
     * @param grPayRequest
     * @return
     */
    public void insertGrPayRequest(GrPayRequest grPayRequest);

    /**
     * 根据id修改
     * @param grPayRequest
     * @return
     */
    public void updateGrPayRequestById(GrPayRequest grPayRequest);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteGrPayRequest(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return GrPayRequest
     */
    public GrPayRequest queryGrPayRequestById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<GrPayRequest>
     */
    public List<GrPayRequest> queryGrPayRequestList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<GrPayRequest>
     */
    public List<GrPayRequest> queryGrPayRequestPageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer queryGrPayRequestPageCount(Map<String, Object> map);
}
