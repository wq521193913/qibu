
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-04-18 18:07:57
*/
@Service
public class GrMembersServiceImpl implements IGrMembersService{

    @Autowired
    private GrMembersDao grMembersDao;

    /**
     * 新增
     * @param grMembers
     * @return
     * @throws Exception
     */
    public void insertGrMembers(GrMembers grMembers) throws Exception{
        grMembersDao.insertGrMembers(grMembers);
    }

    /**
     * 根据id修改
     * @param grMembers
     * @return
     * @throws Exception
     */
    public void updateGrMembersById(GrMembers grMembers) throws Exception{
        if(null == grMembers || null == grMembers.getUid()) throw new CustomException("参数检验有误");
        grMembersDao.updateGrMembersById(grMembers);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteGrMembers(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        grMembersDao.deleteGrMembers(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public GrMembers queryGrMembersById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return grMembersDao.queryGrMembersById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<GrMembers> queryGrMembersList(Map<String, Object> map) throws Exception{
        return grMembersDao.queryGrMembersList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<GrMembers> queryGrMembersPageList(Map<String, Object> map) throws Exception{
        return grMembersDao.queryGrMembersPageList(map);
    }
}
