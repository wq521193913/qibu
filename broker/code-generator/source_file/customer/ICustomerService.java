
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-29 16:53:50
*/
public interface ICustomerService {

    /**
     * 新增
     * @param customer
     * @return
     * @throws Exception
     */
    public void insertCustomer(Customer customer) throws Exception;

    /**
     * 根据id修改
     * @param customer
     * @return
     * @throws Exception
     */
    public void updateCustomerById(Customer customer) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteCustomer(Integer id) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Customer queryCustomerById(Integer id) throws Exception;

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<Customer> queryCustomerList(Map<String, Object> map) throws Exception;

}
