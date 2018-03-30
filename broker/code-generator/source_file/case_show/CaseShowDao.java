
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-03-30 11:04:27
 */
@Repository
public interface CaseShowDao {

    /**
     * 新增
     * @param caseShow
     * @return
     */
    public void insertCaseShow(CaseShow caseShow);

    /**
     * 根据id修改
     * @param caseShow
     * @return
     */
    public void updateCaseShowById(CaseShow caseShow);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteCaseShow(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return CaseShow
     */
    public CaseShow queryCaseShowById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<CaseShow>
     */
    public List<CaseShow> queryCaseShowList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<CaseShow>
     */
    public List<CaseShow> queryCaseShowPageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer queryCaseShowPageCount(Map<String, Object> map);
}
