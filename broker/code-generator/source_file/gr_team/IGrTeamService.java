
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-04-18 18:07:56
*/
public interface IGrTeamService {

    /**
     * 新增
     * @param grTeam
     * @return
     * @throws Exception
     */
    public void insertGrTeam(GrTeam grTeam) throws Exception;

    /**
     * 根据id修改
     * @param grTeam
     * @return
     * @throws Exception
     */
    public void updateGrTeamById(GrTeam grTeam) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteGrTeam(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public GrTeam queryGrTeamById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<GrTeam> queryGrTeamList(Map<String, Object> map) throws Exception;

}
