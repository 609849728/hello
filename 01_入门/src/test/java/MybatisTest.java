import com.sp.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {


    @Test
    public void testGetUserById() throws IOException {
        //1.读取mybatis的配置文件
        String resources = "mybatis-config.xml";
        InputStream input = Resources.getResourceAsStream(resources);

        //2.根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);

        //3.通过SqlSessionFactory创建SqlSession
        SqlSession session = sqlSessionFactory.openSession();

        /*
        4.使用SqlSession执行映射文件中定义的SQL，并返回映射结果
        第一个参数：由SQL映射文件中的<mapper>标签的namespace属性值+<select>标签的id属性值
        第二个参数：传递的参数
         */
        User user = session.selectOne("com.sp.mapper.UserMapper.getUserById", 1);

        //5.处理结果
        System.out.println(user);

        //6.关闭释放资源(只需关闭SqlSession即可)
        session.close();
    }


    @Test
    public void testGetUserByName() throws IOException {
        //1.读取mybatis的配置文件
        String resources = "mybatis-config.xml";
        InputStream input = Resources.getResourceAsStream(resources);

        //2.根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);

        //3.通过SqlSessionFactory创建SqlSession
        SqlSession session = sqlSessionFactory.openSession();

        /*
        4.使用SqlSession执行映射文件中定义的SQL，并返回映射结果
        第一个参数：由SQL映射文件中的<mapper>标签的namespace属性值+<select>标签的id属性值
        第二个参数：传递的参数
         */
        List<User> list = session.selectList("com.sp.mapper.UserMapper.getUserByName", "s");

        //5.处理结果
        for(User user:list) {
            System.out.println(user);
        }

        //6.关闭释放资源(只需关闭SqlSession即可)
        session.close();
    }


    @Test
    public void testAddUser() throws IOException {
        //1.读取mybatis的配置文件
        String resources = "mybatis-config.xml";
        InputStream input = Resources.getResourceAsStream(resources);

        //2.根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);

        //3.通过SqlSessionFactory创建SqlSession
        SqlSession session = sqlSessionFactory.openSession();

        /*
        4.使用SqlSession执行映射文件中定义的SQL，并返回映射结果
         */
        User user = new User();
        user.setUsername("卢本伟");
        user.setPassword("123");
        int i = session.insert("com.sp.mapper.UserMapper.addUser", user);

        //5.处理结果
        System.out.println(i);

        //6.提交事务(写的操作必须要提交事务)
        session.commit();

        //6.关闭释放资源(只需关闭SqlSession即可)
        session.close();
    }


    @Test
    public void testUpdateUser() throws IOException {
        //1.读取mybatis的配置文件
        String resources = "mybatis-config.xml";
        InputStream input = Resources.getResourceAsStream(resources);

        //2.根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);

        //3.通过SqlSessionFactory创建SqlSession
        SqlSession session = sqlSessionFactory.openSession();

        /*
        4.使用SqlSession执行映射文件中定义的SQL，并返回映射结果
         */
        User user = new User();
        user.setId(5);
        user.setPassword("123");
        int i = session.update("com.sp.mapper.UserMapper.updateUser", user);

        //5.处理结果
        System.out.println(i);

        //6.提交事务(写的操作必须要提交事务)
        session.commit();

        //6.关闭释放资源(只需关闭SqlSession即可)
        session.close();
    }


    @Test
    public void testDeleteUserById() throws IOException {
        //1.读取mybatis的配置文件
        String resources = "mybatis-config.xml";
        InputStream input = Resources.getResourceAsStream(resources);

        //2.根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);

        //3.通过SqlSessionFactory创建SqlSession
        SqlSession session = sqlSessionFactory.openSession();

        /*
        4.使用SqlSession执行映射文件中定义的SQL，并返回映射结果
         */
        int i = session.delete("com.sp.mapper.UserMapper.deleteUserById", 7);

        //5.处理结果
        System.out.println(i);

        //6.提交事务(写的操作必须要提交事务)
        session.commit();

        //6.关闭释放资源(只需关闭SqlSession即可)
        session.close();
    }


}
