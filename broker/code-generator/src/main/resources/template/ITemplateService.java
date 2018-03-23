
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date #today
*/
public interface ITemplateService {

    /**
     * 新增
     * @param template
     * @return
     * @throws Exception
     */
    public void insertTemplate(Template template) throws Exception;

    /**
     * 根据id修改
     * @param template
     * @return
     * @throws Exception
     */
    public void updateTemplateById(Template template) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteTemplate(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Template queryTemplateById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<Template> queryTemplateList(Map<String, Object> map) throws Exception;

}
