
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
 * @date 2018-03-29 16:53:50
*/
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	
	private final Logger logger = Logger.getLogger(CustomerController.class);

    @Autowired
    private ICustomerService customerService;

    /**
     * 新增
     * @param customer
     * @return 
     * @author Administrator
     * @date 2018-03-29 16:53:50
    */
    @RequestMapping(value = "insertCustomer", method = RequestMethod.POST)
    @ResponseBody
    public Result insertCustomer(Customer customer){
        Result result = new Result();
        try {
            customerService.insertCustomer(customer);
        }catch (CustomException ce){
            logger.error("params:" + customer, ce);
            return Result.getSystemErrorMsg(ce);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("CustomerController.insertCustomer error:", e);
        }
        return result;
    }

    /**
     * 根据id更新表数据
     * @param customer
     * @return 
     * @author Administrator
     * @date 2018-03-29 16:53:50
    */
    @RequestMapping(value = "updateCustomerById", method = RequestMethod.POST)
    @ResponseBody
    public Result updateCustomerById(Customer customer){
        Result result = new Result();
        try {
            customerService.updateCustomerById(customer);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("CustomerController.updateCustomerById error:", e);
        }
        return result;
    }

    /**
     * 删除表数据
     * @param id
     * @return
     * @author Administrator
     * @date 2018-03-29 16:53:50
    */
    @RequestMapping(value = "deleteCustomer", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteCustomer(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            customerService.deleteCustomer(id);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("CustomerController.deleteCustomer error:", e);
        }
        return result;
    }

    /**
     * 根据id查询数据
     * @param id
     * @return 
     * @author Administrator
     * @date 2018-03-29 16:53:50
    */
    @RequestMapping(value = "queryCustomerById", method = RequestMethod.GET)
    @ResponseBody
    public Result queryCustomerById(@RequestParam(value = "id")Integer id){
        Result result = new Result();
        try {
            Customer customer = customerService.queryCustomerById(id);
            if(null == customer){
                result.setSuccess(false);
                result.setMsg("无法查询此数据");
            }else {
                result.setData(customer);
            }
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("CustomerController.queryCustomerById error:", e);
        }
        return result;
    }

    /**
     * 查询列表
     * @param
     * @return 
     * @author Administrator
     * @date 2018-03-29 16:53:50
    */
    @RequestMapping(value = "queryCustomerList", method = RequestMethod.GET)
    @ResponseBody
    public Result queryCustomerList(ServletRequest request){
        Result result = new Result();
        try {
            Map<String, Object> paramMap = WebUtils.getParametersStartingWith(request,"");
            List<Customer> customerList = customerService.queryCustomerList(paramMap);
            result.setData(customerList);
        }catch (Exception e){
            result = Result.getSystemErrorMsg(e);
            logger.error("CustomerController.queryCustomerList error:", e);
        }
        return result;
    }
}
