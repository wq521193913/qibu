
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-04-18 18:07:55
*/
@Service
public class GrGoodsDetailServiceImpl implements IGrGoodsDetailService{

    @Autowired
    private GrGoodsDetailDao grGoodsDetailDao;

    /**
     * 新增
     * @param grGoodsDetail
     * @return
     * @throws Exception
     */
    public void insertGrGoodsDetail(GrGoodsDetail grGoodsDetail) throws Exception{
        grGoodsDetailDao.insertGrGoodsDetail(grGoodsDetail);
    }

    /**
     * 根据id修改
     * @param grGoodsDetail
     * @return
     * @throws Exception
     */
    public void updateGrGoodsDetailById(GrGoodsDetail grGoodsDetail) throws Exception{
        if(null == grGoodsDetail || null == grGoodsDetail.getUid()) throw new CustomException("参数检验有误");
        grGoodsDetailDao.updateGrGoodsDetailById(grGoodsDetail);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteGrGoodsDetail(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        grGoodsDetailDao.deleteGrGoodsDetail(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public GrGoodsDetail queryGrGoodsDetailById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return grGoodsDetailDao.queryGrGoodsDetailById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<GrGoodsDetail> queryGrGoodsDetailList(Map<String, Object> map) throws Exception{
        return grGoodsDetailDao.queryGrGoodsDetailList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<GrGoodsDetail> queryGrGoodsDetailPageList(Map<String, Object> map) throws Exception{
        return grGoodsDetailDao.queryGrGoodsDetailPageList(map);
    }
}
