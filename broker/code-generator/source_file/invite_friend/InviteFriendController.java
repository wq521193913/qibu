
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-23 22:07:05
*/
@Controller
@RequestMapping(value = "/inviteFriend")
public class InviteFriendController {
	
	private final Logger logger = Logger.getLogger(InviteFriendController.class);

    @Autowired
    private IInviteFriendService inviteFriendService;

    /**
     * 新增
     * @param inviteFriend
     * @return 
     * @author Administrator
     * @date 2018-03-23 22:07:05
    */
    @RequestMapping(value = "insertInviteFriend", method = RequestMethod.POST)
    @ResponseBody
    public Result insertInviteFriend(InviteFriend inviteFriend){
        Result result = new Result();
        try {
            inviteFriendService.insertInviteFriend(inviteFriend);
        }catch (CustomException ce){
            logger.error("params:" + inviteFriend, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("InviteFriendController.insertInviteFriend error:", e);
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param inviteFriend
     * @return 
     * @author Administrator
     * @date 2018-03-23 22:07:05
    */
    @RequestMapping(value = "updateInviteFriendById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateInviteFriendById(InviteFriend inviteFriend){
        Result result = new Result();
        try {
            inviteFriendService.updateInviteFriendById(inviteFriend);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("InviteFriendController.updateInviteFriendById error:", e);
        }
        return result;
    }

    /**
     * 删除表数据
     * @param id
     * @return
     * @author Administrator
     * @date 2018-03-23 22:07:05
    */
    @RequestMapping(value = "deleteInviteFriend", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteInviteFriend(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            inviteFriendService.deleteInviteFriend(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("InviteFriendController.deleteInviteFriend error:", e);
        }
        return result;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return 
     * @author Administrator
     * @date 2018-03-23 22:07:05
    */
    @RequestMapping(value = "queryInviteFriendById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryInviteFriendById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            InviteFriend inviteFriend = inviteFriendService.queryInviteFriendById(id);
            if(null == inviteFriend){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(inviteFriend);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("InviteFriendController.queryInviteFriendById error:", e);
        }
        return result;
    }

    /**
     * 查询列表
     * @param
     * @return 
     * @author Administrator
     * @date 2018-03-23 22:07:05
    */
    @RequestMapping(value = "queryInviteFriendList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryInviteFriendList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request,"");
            List<InviteFriend> inviteFriendList = inviteFriendService.queryInviteFriendList(paramMap);
            result.setData(inviteFriendList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("InviteFriendController.queryInviteFriendList error:", e);
        }
        return result;
    }
}
