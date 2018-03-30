
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018-03-30 11:04:27
*/
@Service
public class BrokerBribeServiceImpl implements IBrokerBribeService{

    @Autowired
    private BrokerBribeDao brokerBribeDao;

    /**
     * 新增
     * @param brokerBribe
     * @return
     * @throws Exception
     */
    public void insertBrokerBribe(BrokerBribe brokerBribe) throws Exception{
        brokerBribeDao.insertBrokerBribe(brokerBribe);
    }

    /**
     * 根据id修改
     * @param brokerBribe
     * @return
     * @throws Exception
     */
    public void updateBrokerBribeById(BrokerBribe brokerBribe) throws Exception{
        if(null == brokerBribe || null == brokerBribe.getUid()) throw new CustomException("参数检验有误");
        brokerBribeDao.updateBrokerBribeById(brokerBribe);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public void deleteBrokerBribe(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        brokerBribeDao.deleteBrokerBribe(id);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public BrokerBribe queryBrokerBribeById(Integer id) throws Exception{
        if(null == id) throw new CustomException("参数检验有误");
        return brokerBribeDao.queryBrokerBribeById(id);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<BrokerBribe> queryBrokerBribeList(Map<String, Object> map) throws Exception{
        return brokerBribeDao.queryBrokerBribeList(map);
    }

    /**
     * 查询列表
     * @param map
     * @return
     */
    public List<BrokerBribe> queryBrokerBribePageList(Map<String, Object> map) throws Exception{
        return brokerBribeDao.queryBrokerBribePageList(map);
    }
}
