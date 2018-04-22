
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-26 10:26:30
*/
@Service
public class SysUserServiceImpl implements ISysUserService{

    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 新增
     * @param sysUser
     * @return
     * @throws Exception
     */
    public void insertSysUser(SysUser sysUser) throws Exception{
        sysUserDao.insertSysUser(sysUser);
    }

    /**
     * 根据id修改
     * @param sysUser
     * @return
     * @throws Exception
     */
    public void updateSysUserById(SysUser sysUser) throws Exception{
        if(null == sysUser || null == sysUser.getUid()) throw new CustomException("参数检验有误");
        sysUserDao.updateSysUserById(sysUser);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteSysUser(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        sysUserDao.deleteSysUser(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public SysUser querySysUserById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return sysUserDao.querySysUserById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<SysUser> querySysUserList(Map<String, Object> map) throws Exception{
        return sysUserDao.querySysUserList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<SysUser> querySysUserPageList(Map<String, Object> map) throws Exception{
        return sysUserDao.querySysUserPageList(map);
    }
}
