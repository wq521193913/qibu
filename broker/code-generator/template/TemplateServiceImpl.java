
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date #today
*/
@Service
public class TemplateServiceImpl implements ITemplateService{

    @Autowired
    private TemplateDao templateDao;

    /**
     * 新增
     * @param template
     * @return
     * @throws Exception
     */
    public void insertTemplate(Template template) throws Exception{
        templateDao.insertTemplate(template);
    }

    /**
     * 根据id修改
     * @param template
     * @return
     * @throws Exception
     */
    public void updateTemplateById(Template template) throws Exception{
        if(null == template || null == template.getUid()) throw new CustomException("参数检验有误");
        templateDao.updateTemplateById(template);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteTemplate(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        templateDao.deleteTemplate(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Template queryTemplateById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return templateDao.queryTemplateById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<Template> queryTemplateList(Map<String, Object> map) throws Exception{
        return templateDao.queryTemplateList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<Template> queryTemplatePageList(Map<String, Object> map) throws Exception{
        return templateDao.queryTemplatePageList(map);
    }
}
