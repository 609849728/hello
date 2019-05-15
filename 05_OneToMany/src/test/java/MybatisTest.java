
import com.sp.dao.OrderDao;
import com.sp.dao.UserDao;
import com.sp.entity.Order;
import com.sp.entity.User;
import com.sp.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisTest {


    //一对多：嵌套结果
    @Test
    public void test01() {
        SqlSession session = MybatisUtils.getSqlSession();

        UserDao userDao = session.getMapper(UserDao.class);
        User user = userDao.getUserById(8);
        System.out.println(user);
    }



    //多对一==一对一：嵌套结果
    @Test
    public void test02() {
        SqlSession session = MybatisUtils.getSqlSession();

        OrderDao orderDao = session.getMapper(OrderDao.class);
        Order order = orderDao.getOrderById(3);
        System.out.println(order);
    }







}
