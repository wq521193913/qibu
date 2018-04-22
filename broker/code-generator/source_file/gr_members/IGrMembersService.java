
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-04-18 18:07:57
*/
public interface IGrMembersService {

    /**
     * 新增
     * @param grMembers
     * @return
     * @throws Exception
     */
    public void insertGrMembers(GrMembers grMembers) throws Exception;

    /**
     * 根据id修改
     * @param grMembers
     * @return
     * @throws Exception
     */
    public void updateGrMembersById(GrMembers grMembers) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteGrMembers(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public GrMembers queryGrMembersById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<GrMembers> queryGrMembersList(Map<String, Object> map) throws Exception;

}
