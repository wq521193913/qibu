
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-03-26 10:26:30
 */
@Repository
public interface SysUserDao {

    /**
     * 新增
     * @param sysUser
     * @return
     */
    public void insertSysUser(SysUser sysUser);

    /**
     * 根据id修改
     * @param sysUser
     * @return
     */
    public void updateSysUserById(SysUser sysUser);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteSysUser(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return SysUser
     */
    public SysUser querySysUserById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<SysUser>
     */
    public List<SysUser> querySysUserList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<SysUser>
     */
    public List<SysUser> querySysUserPageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer querySysUserPageCount(Map<String, Object> map);
}
