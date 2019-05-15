import com.sp.dao.CustomerDao;
import com.sp.dao.UserDao;
import com.sp.entity.Customer;
import com.sp.entity.User;
import com.sp.entity.VO;
import com.sp.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {


    //测试<if>元素
    @Test
    public void test01() {
        SqlSession session = MybatisUtils.getSqlSession();

        UserDao userDao = session.getMapper(UserDao.class);
        //传入的是null或者''，那么就是查询全部。如果传入了字符串，那么<if>元素的条件成立，就成了模糊查询
        List<User> userList = userDao.getUserList("s");
        for(User user:userList) {
            System.out.println(user);
        }

        session.close();
    }



    //测试<choose><when><otherwise>
    @Test
    public void test02() {
        SqlSession session = MybatisUtils.getSqlSession();

        CustomerDao customerDao = session.getMapper(CustomerDao.class);

        List<Customer> list = customerDao.getCustomerList("","zhubo");
        for(Customer customer : list) {
            System.out.println(customer);
        }

        session.close();
    }




    //测试<where>
    @Test
    public void test03() {
        SqlSession session = MybatisUtils.getSqlSession();

        UserDao userDao = session.getMapper(UserDao.class);
        List<User> list = userDao.getUserList02("");
        for(User user:list) {
            System.out.println(user);
        }

        session.close();
    }



    //测试<set>
    @Test
    public void test04() {
        SqlSession session = MybatisUtils.getSqlSession();

        CustomerDao customerDao = session.getMapper(CustomerDao.class);

        Customer customer = new Customer();
        customer.setId(2);  //必须设置id
        customer.setJob("华为CEO");
        customerDao.updateCustomer(customer);

        session.commit();
        session.close();
    }



    //测试<trim>代替<where>
    @Test
    public void test05() {
        SqlSession session = MybatisUtils.getSqlSession();

        CustomerDao customerDao = session.getMapper(CustomerDao.class);
        List<Customer> list = customerDao.getCustomerList02("a", "z");
        for(Customer customer:list) {
            System.out.println(customer);
        }

        session.close();
    }



    //测试<trim>代替<set>
    @Test
    public void test06() {
        SqlSession session = MybatisUtils.getSqlSession();

        CustomerDao customerDao = session.getMapper(CustomerDao.class);

        Customer customer = new Customer();
        customer.setId(2);  //必须设置id
        customer.setJob("总监");
        customer.setPhone(666);

        customerDao.updateCustomer02(customer);

        session.commit();
        session.close();
    }




    //测试<foreach>，参数为单个且是数组的情况
    @Test
    public void test07() {
        SqlSession session = MybatisUtils.getSqlSession();

        UserDao userDao = session.getMapper(UserDao.class);

        Object[] objects = {3,"4",8};
        List<User> list = userDao.getUserListById(objects);
        for(User user:list) {
            System.out.println(user);
        }

        session.close();
    }


    //测试<foreach>，参数为单个且是List集合的情况
    @Test
    public void test08() {
        SqlSession session = MybatisUtils.getSqlSession();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        //参数是List的情况
        List<User> userList = session.selectList("com.sp.dao.UserDao.getUserListById02", list);
        for(User user:userList) {
            System.out.println(user);
        }

        session.close();
    }




    //测试<foreach>，参数为单个且是Map集合的情况
    @Test
    public void test09() {
        SqlSession session = MybatisUtils.getSqlSession();

        Integer[] idArray = {1,8,12};

        Map<String,Object> map = new HashMap<>();
        map.put("ids",idArray);


        //参数是Map的情况
        List<User> userList = session.selectList("com.sp.dao.UserDao.getUserListById03", map);
        for(User user:userList) {
            System.out.println(user);
        }

        session.close();
    }



    //测试<foreach>，参数是对象的情况，对象中包含一个List集合的属性
    @Test
    public void test10() {
        SqlSession session = MybatisUtils.getSqlSession();


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(6);

        VO vo = new VO();
        vo.setIdList(list);


        //参数是对象的情况
        List<User> userList = session.selectList("com.sp.dao.UserDao.getUserListById04", vo);
        for(User user:userList) {
            System.out.println(user);
        }

        session.close();
    }





    //测试<bind>，参数是对象的情况
    @Test
    public void test11() {
        SqlSession session = MybatisUtils.getSqlSession();

        User user = new User();
        user.setUsername("s");

        //参数是对象的情况
        List<User> userList = session.selectList("com.sp.dao.UserDao.bindTest", user);
        for(User u:userList) {
            System.out.println(u);
        }

        session.close();
    }



    //测试<bind>，参数是普通类型的情况
    @Test
    public void test12() {
        SqlSession session = MybatisUtils.getSqlSession();

        UserDao userDao = session.getMapper(UserDao.class);

        //参数是对象的情况
        List<User> userList = userDao.bindTest02("s");
        for(User u:userList) {
            System.out.println(u);
        }

        session.close();
    }








}
