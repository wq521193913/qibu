
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-04-18 18:07:55
 */
@Repository
public interface GrGoodsDao {

    /**
     * 新增
     * @param grGoods
     * @return
     */
    public void insertGrGoods(GrGoods grGoods);

    /**
     * 根据id修改
     * @param grGoods
     * @return
     */
    public void updateGrGoodsById(GrGoods grGoods);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteGrGoods(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return GrGoods
     */
    public GrGoods queryGrGoodsById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<GrGoods>
     */
    public List<GrGoods> queryGrGoodsList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<GrGoods>
     */
    public List<GrGoods> queryGrGoodsPageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer queryGrGoodsPageCount(Map<String, Object> map);
}
