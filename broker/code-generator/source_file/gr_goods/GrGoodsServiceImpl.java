
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
public class GrGoodsServiceImpl implements IGrGoodsService{

    @Autowired
    private GrGoodsDao grGoodsDao;

    /**
     * 新增
     * @param grGoods
     * @return
     * @throws Exception
     */
    public void insertGrGoods(GrGoods grGoods) throws Exception{
        grGoodsDao.insertGrGoods(grGoods);
    }

    /**
     * 根据id修改
     * @param grGoods
     * @return
     * @throws Exception
     */
    public void updateGrGoodsById(GrGoods grGoods) throws Exception{
        if(null == grGoods || null == grGoods.getUid()) throw new CustomException("参数检验有误");
        grGoodsDao.updateGrGoodsById(grGoods);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteGrGoods(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        grGoodsDao.deleteGrGoods(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public GrGoods queryGrGoodsById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return grGoodsDao.queryGrGoodsById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<GrGoods> queryGrGoodsList(Map<String, Object> map) throws Exception{
        return grGoodsDao.queryGrGoodsList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<GrGoods> queryGrGoodsPageList(Map<String, Object> map) throws Exception{
        return grGoodsDao.queryGrGoodsPageList(map);
    }
}
