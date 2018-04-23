
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-04-18 18:07:55
*/
public interface IGrGoodsDetailService {

    /**
     * 新增
     * @param grGoodsDetail
     * @return
     * @throws Exception
     */
    public void insertGrGoodsDetail(GrGoodsDetail grGoodsDetail) throws Exception;

    /**
     * 根据id修改
     * @param grGoodsDetail
     * @return
     * @throws Exception
     */
    public void updateGrGoodsDetailById(GrGoodsDetail grGoodsDetail) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteGrGoodsDetail(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public GrGoodsDetail queryGrGoodsDetailById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<GrGoodsDetail> queryGrGoodsDetailList(Map<String, Object> map) throws Exception;

}
