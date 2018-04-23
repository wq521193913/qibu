
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-04-18 18:07:56
*/
public interface IGrPayRequestService {

    /**
     * 新增
     * @param grPayRequest
     * @return
     * @throws Exception
     */
    public void insertGrPayRequest(GrPayRequest grPayRequest) throws Exception;

    /**
     * 根据id修改
     * @param grPayRequest
     * @return
     * @throws Exception
     */
    public void updateGrPayRequestById(GrPayRequest grPayRequest) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteGrPayRequest(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public GrPayRequest queryGrPayRequestById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<GrPayRequest> queryGrPayRequestList(Map<String, Object> map) throws Exception;

}
