
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-04-18 18:07:57
 */
@Repository
public interface GrMembersDao {

    /**
     * 新增
     * @param grMembers
     * @return
     */
    public void insertGrMembers(GrMembers grMembers);

    /**
     * 根据id修改
     * @param grMembers
     * @return
     */
    public void updateGrMembersById(GrMembers grMembers);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteGrMembers(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return GrMembers
     */
    public GrMembers queryGrMembersById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<GrMembers>
     */
    public List<GrMembers> queryGrMembersList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<GrMembers>
     */
    public List<GrMembers> queryGrMembersPageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer queryGrMembersPageCount(Map<String, Object> map);
}
