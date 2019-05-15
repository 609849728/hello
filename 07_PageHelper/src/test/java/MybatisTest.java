import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sp.dao.UserDao;
import com.sp.entity.User;
import com.sp.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest {


    //分页
    @Test
    public void test01() {
        SqlSession session = MybatisUtils.getSqlSession();

        UserDao userDao = session.getMapper(UserDao.class);

        //调用之前，传入分页的参数(当前页,页面大小)
        PageHelper.offsetPage(0,2);
        //PageHelper.startPage(2,2);

        //执行方法
        List<User> userList = userDao.getUserList();

        //创建PageInfo，传入方法的返回值，查询出来的所有集合
        PageInfo pageInfo = new PageInfo(userList);
        /*System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("页面大小："+pageInfo.getPageSize());
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("每页的集合：");*/
        List<User> list = pageInfo.getList();
        for(User user:list) {
            System.out.println(user);
        }

        session.close();
    }



}
