
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-04-18 18:07:55
 */
@Repository
public interface GrGoodsDetailDao {

    /**
     * 新增
     * @param grGoodsDetail
     * @return
     */
    public void insertGrGoodsDetail(GrGoodsDetail grGoodsDetail);

    /**
     * 根据id修改
     * @param grGoodsDetail
     * @return
     */
    public void updateGrGoodsDetailById(GrGoodsDetail grGoodsDetail);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteGrGoodsDetail(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return GrGoodsDetail
     */
    public GrGoodsDetail queryGrGoodsDetailById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<GrGoodsDetail>
     */
    public List<GrGoodsDetail> queryGrGoodsDetailList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<GrGoodsDetail>
     */
    public List<GrGoodsDetail> queryGrGoodsDetailPageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer queryGrGoodsDetailPageCount(Map<String, Object> map);
}
