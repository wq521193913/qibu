
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Administrator
 * @date 2018-03-29 16:53:50
 */
@Repository
public interface CustomerDao {

    /**
     * 新增
     * @param customer
     * @return
     */
    public void insertCustomer(Customer customer);

    /**
     * 根据id修改
     * @param customer
     * @return
     */
    public void updateCustomerById(Customer customer);

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteCustomer(Integer id);

    /**
     * 根据id查询
     * @param id
     * @return Customer
     */
    public Customer queryCustomerById(Integer id);

    /**
     * 查询列表
     * @param map
     * @return List<Customer>
     */
    public List<Customer> queryCustomerList(Map<String, Object> map);

    /**
     * 查询分页列表
     * @param map
     * @return List<Customer>
     */
    public List<Customer> queryCustomerPageList(Map<String, Object> map);

    /**
     * 查询分页列表条数
     * @param map
     * @return Integer
     */
    public Integer queryCustomerPageCount(Map<String, Object> map);
}
