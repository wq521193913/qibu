
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
public class GrTeamServiceImpl implements IGrTeamService{

    @Autowired
    private GrTeamDao grTeamDao;

    /**
     * 新增
     * @param grTeam
     * @return
     * @throws Exception
     */
    public void insertGrTeam(GrTeam grTeam) throws Exception{
        grTeamDao.insertGrTeam(grTeam);
    }

    /**
     * 根据id修改
     * @param grTeam
     * @return
     * @throws Exception
     */
    public void updateGrTeamById(GrTeam grTeam) throws Exception{
        if(null == grTeam || null == grTeam.getUid()) throw new CustomException("参数检验有误");
        grTeamDao.updateGrTeamById(grTeam);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteGrTeam(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        grTeamDao.deleteGrTeam(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public GrTeam queryGrTeamById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return grTeamDao.queryGrTeamById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<GrTeam> queryGrTeamList(Map<String, Object> map) throws Exception{
        return grTeamDao.queryGrTeamList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<GrTeam> queryGrTeamPageList(Map<String, Object> map) throws Exception{
        return grTeamDao.queryGrTeamPageList(map);
    }
}
