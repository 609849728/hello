import com.sp.dao.PersonDao;
import com.sp.entity.Person;
import com.sp.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisTest {


    //一对一：嵌套查询
    @Test
    public void test01() {
        SqlSession session = MybatisUtils.getSqlSession();

        PersonDao personDao = session.getMapper(PersonDao.class);
        Person person = personDao.getPersonById(2);
        System.out.println(person);

        session.close();

        /*
        结果：嵌套查询要执行多条SQL，消耗数据库性能并且降低查询效率

        20:29:07 DEBUG com.sp.dao.PersonDao.getPersonById - ==>  Preparing: select * from t_person where id=?
        20:29:07 DEBUG com.sp.dao.PersonDao.getPersonById - ==> Parameters: 2(Integer)
        20:29:07 DEBUG com.sp.dao.CodeDao.getCodeById - ====>  Preparing: select * from t_code where id=?
        20:29:07 DEBUG com.sp.dao.CodeDao.getCodeById - ====> Parameters: 1(Integer)
        20:29:07 DEBUG com.sp.dao.CodeDao.getCodeById - <====      Total: 1
        20:29:07 DEBUG com.sp.dao.PersonDao.getPersonById - <==      Total: 1
        Person(id=2, name=牛逼, code=Code(id=1, code=77499))
         */
    }



    //一对一：嵌套结果
    @Test
    public void test02() {
        SqlSession session = MybatisUtils.getSqlSession();

        PersonDao personDao = session.getMapper(PersonDao.class);
        Person person = personDao.getPersonById02(2);
        System.out.println(person);

        session.close();

        /*
        结果：只执行了一条SQL，

        20:42:24 DEBUG com.sp.dao.PersonDao.getPersonById02 - ==>  Preparing: SELECT p.*, c.code FROM t_person p, t_code c WHERE p.code_id = c.id AND p.id = ?
        20:42:24 DEBUG com.sp.dao.PersonDao.getPersonById02 - ==> Parameters: 2(Integer)
        20:42:24 DEBUG com.sp.dao.PersonDao.getPersonById02 - <==      Total: 1
        Person(id=2, name=牛逼, code=Code(id=1, code=77499))
         */
    }



}
