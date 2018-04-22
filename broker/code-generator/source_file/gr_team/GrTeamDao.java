
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-04-18 18:07:56
 */
@Repository
public interface GrTeamDao {

    /**
     * 新增
     * @param grTeam
     * @return
     */
    public void insertGrTeam(GrTeam grTeam);

    /**
     * 根据id修改
     * @param grTeam
     * @return
     */
    public void updateGrTeamById(GrTeam grTeam);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteGrTeam(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return GrTeam
     */
    public GrTeam queryGrTeamById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<GrTeam>
     */
    public List<GrTeam> queryGrTeamList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<GrTeam>
     */
    public List<GrTeam> queryGrTeamPageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer queryGrTeamPageCount(Map<String, Object> map);
}
