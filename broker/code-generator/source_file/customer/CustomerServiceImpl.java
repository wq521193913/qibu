
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-29 16:53:50
*/
@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private CustomerDao customerDao;

    /**
     * 新增
     * @param customer
     * @return
     * @throws Exception
     */
    public void insertCustomer(Customer customer) throws Exception{
        customerDao.insertCustomer(customer);
    }

    /**
     * 根据id修改
     * @param customer
     * @return
     * @throws Exception
     */
    public void updateCustomerById(Customer customer) throws Exception{
        if(null == customer || null == customer.getUid()) throw new CustomException("参数检验有误");
        customerDao.updateCustomerById(customer);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteCustomer(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        customerDao.deleteCustomer(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Customer queryCustomerById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return customerDao.queryCustomerById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<Customer> queryCustomerList(Map<String, Object> map) throws Exception{
        return customerDao.queryCustomerList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<Customer> queryCustomerPageList(Map<String, Object> map) throws Exception{
        return customerDao.queryCustomerPageList(map);
    }
}
