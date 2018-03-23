
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-23 22:07:05
*/
@Service
public class InviteFriendServiceImpl implements IInviteFriendService{

    @Autowired
    private InviteFriendDao inviteFriendDao;

    /**
     * 新增
     * @param inviteFriend
     * @return
     * @throws Exception
     */
    public void insertInviteFriend(InviteFriend inviteFriend) throws Exception{
        inviteFriendDao.insertInviteFriend(inviteFriend);
    }

    /**
     * 根据id修改
     * @param inviteFriend
     * @return
     * @throws Exception
     */
    public void updateInviteFriendById(InviteFriend inviteFriend) throws Exception{
        if(null == inviteFriend || null == inviteFriend.getUid()) throw new CustomException("参数检验有误");
        inviteFriendDao.updateInviteFriendById(inviteFriend);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteInviteFriend(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        inviteFriendDao.deleteInviteFriend(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public InviteFriend queryInviteFriendById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return inviteFriendDao.queryInviteFriendById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<InviteFriend> queryInviteFriendList(Map<String, Object> map) throws Exception{
        return inviteFriendDao.queryInviteFriendList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<InviteFriend> queryInviteFriendPageList(Map<String, Object> map) throws Exception{
        return inviteFriendDao.queryInviteFriendPageList(map);
    }
}
