
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-04-18 18:07:56
*/
@Service
public class GrPayRequestServiceImpl implements IGrPayRequestService{

    @Autowired
    private GrPayRequestDao grPayRequestDao;

    /**
     * 新增
     * @param grPayRequest
     * @return
     * @throws Exception
     */
    public void insertGrPayRequest(GrPayRequest grPayRequest) throws Exception{
        grPayRequestDao.insertGrPayRequest(grPayRequest);
    }

    /**
     * 根据id修改
     * @param grPayRequest
     * @return
     * @throws Exception
     */
    public void updateGrPayRequestById(GrPayRequest grPayRequest) throws Exception{
        if(null == grPayRequest || null == grPayRequest.getUid()) throw new CustomException("参数检验有误");
        grPayRequestDao.updateGrPayRequestById(grPayRequest);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteGrPayRequest(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        grPayRequestDao.deleteGrPayRequest(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public GrPayRequest queryGrPayRequestById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return grPayRequestDao.queryGrPayRequestById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<GrPayRequest> queryGrPayRequestList(Map<String, Object> map) throws Exception{
        return grPayRequestDao.queryGrPayRequestList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<GrPayRequest> queryGrPayRequestPageList(Map<String, Object> map) throws Exception{
        return grPayRequestDao.queryGrPayRequestPageList(map);
    }
}
