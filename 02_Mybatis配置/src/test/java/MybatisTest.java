import com.sp.dao.UserDao;
import com.sp.entity.User;
import com.sp.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MybatisTest {


    @Test
    public void test01() {
        SqlSession session = MybatisUtils.getSqlSession();

        UserDao userDao = session.getMapper(UserDao.class);
        //直接传入参数
        User user = userDao.login("sp","123");
        //测试别名
        //User user = userDao.login03("sp","123");
        System.out.println(user);
    }



    @Test
    public void test02() {
        SqlSession session = MybatisUtils.getSqlSession();

        //直接传入map，那就用${key}获取value
        Map<String,Object> map = new HashMap<>();
        map.put("name","sp");
        map.put("pass","123");

        UserDao userDao = session.getMapper(UserDao.class);
        User user = userDao.login02(map);
        System.out.println(user);
    }


    //主键回填
    @Test
    public void test03() {
        SqlSession session = MybatisUtils.getSqlSession();

        //并没有设置id属性
        User user = new User();
        user.setUsername("aa");
        user.setPassword("123");

        UserDao userDao = session.getMapper(UserDao.class);
        Integer i = userDao.addUser(user);
        System.out.println(i);
        System.out.println(user.getId());  //主键会回填到对象的id属性上

        session.commit();
        session.close();
    }


    //主键回填Map集合
    @Test
    public void test04() {
        SqlSession session = MybatisUtils.getSqlSession();

        //主键回填map.put("id",主键)
        Map<String,Object> map = new HashMap<>();
        map.put("username","nb");
        map.put("password","123");

        UserDao userDao = session.getMapper(UserDao.class);
        Integer i = userDao.addUser02(map);
        System.out.println(i);

        Set<String> keySet = map.keySet();
        for(String key:keySet) {
            System.out.println(key);
            System.out.println(map.get(key));
        }

        session.commit();
        session.close();
    }



    /*
    测试一级缓存，同一个SqlSession共享，默认是开启的
    当SqlSession进行close()或者clearCache()，该SqlSession缓存就会被清空
     */
    @Test
    public void test05() {
        SqlSession session = MybatisUtils.getSqlSession();
        User user = session.selectOne("com.sp.dao.EacheDao.getUserById", 8);
        System.out.println(user);

        System.out.println("##################################################");

        User user2 = session.selectOne("com.sp.dao.EacheDao.getUserById", 8);
        System.out.println(user2);

        /*
        结果：一级缓存默认开启，不需要任何配置

        12:10:08 DEBUG com.sp.dao.EacheDao.getUserById - ==>  Preparing: select * from t_user where id=?
        12:10:08 DEBUG com.sp.dao.EacheDao.getUserById - ==> Parameters: 8(Integer)
        12:10:08 DEBUG com.sp.dao.EacheDao.getUserById - <==      Total: 1
        User(id=8, username=卢本伟, password=123)
        ##################################################
        User(id=8, username=卢本伟, password=123)
         */
    }




    /*
    测试二级缓存，SqlSessionFactory级别的，所有SqlSession共享
     */
    @Test
    public void test06() {
        //首先创建SqlSession1
        SqlSession session = MybatisUtils.getSqlSession();
        //SqlSession1查询
        User user = session.selectOne("com.sp.dao.EacheDao.getUserById02", 8);
        session.commit();  //想要成功二级缓存，就必须提交事务
        System.out.println(user);

        System.out.println("##################################################");

        //再创建SqlSession2
        SqlSession session2 = MybatisUtils.getSqlSession();
        //SqlSession2查询
        User user2 = session2.selectOne("com.sp.dao.EacheDao.getUserById02", 8);
        System.out.println(user2);

        /*
        二级缓存没开启的情况：和数据库交互了两次
        12:14:29 DEBUG com.sp.dao.EacheDao.getUserById02 - ==>  Preparing: select * from t_user where id=?
        12:14:29 DEBUG com.sp.dao.EacheDao.getUserById02 - ==> Parameters: 8(Integer)
        12:14:29 DEBUG com.sp.dao.EacheDao.getUserById02 - <==      Total: 1
        User(id=8, username=卢本伟, password=123)
        ##################################################
        12:14:29 DEBUG com.sp.dao.EacheDao.getUserById02 - ==>  Preparing: select * from t_user where id=?
        12:14:29 DEBUG com.sp.dao.EacheDao.getUserById02 - ==> Parameters: 8(Integer)
        12:14:29 DEBUG com.sp.dao.EacheDao.getUserById02 - <==      Total: 1
        User(id=8, username=卢本伟, password=123)


        二级缓存开启成功：
        12:25:26 DEBUG com.sp.dao.EacheDao - Cache Hit Ratio [com.sp.dao.EacheDao]: 0.0
        12:25:26 DEBUG com.sp.dao.EacheDao.getUserById02 - ==>  Preparing: select * from t_user where id=?
        12:25:26 DEBUG com.sp.dao.EacheDao.getUserById02 - ==> Parameters: 8(Integer)
        12:25:26 DEBUG com.sp.dao.EacheDao.getUserById02 - <==      Total: 1
        User(id=8, username=卢本伟, password=123)
        ##################################################
        12:25:26 DEBUG com.sp.dao.EacheDao - Cache Hit Ratio [com.sp.dao.EacheDao]: 0.5
        User(id=8, username=卢本伟, password=123)
         */

    }







}
