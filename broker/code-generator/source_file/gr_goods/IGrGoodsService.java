
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-04-18 18:07:55
*/
public interface IGrGoodsService {

    /**
     * 新增
     * @param grGoods
     * @return
     * @throws Exception
     */
    public void insertGrGoods(GrGoods grGoods) throws Exception;

    /**
     * 根据id修改
     * @param grGoods
     * @return
     * @throws Exception
     */
    public void updateGrGoodsById(GrGoods grGoods) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteGrGoods(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public GrGoods queryGrGoodsById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<GrGoods> queryGrGoodsList(Map<String, Object> map) throws Exception;

}
