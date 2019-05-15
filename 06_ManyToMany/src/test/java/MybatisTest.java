import com.sp.dao.ClassDao;
import com.sp.dao.TeacherDao;
import com.sp.entity.Class;
import com.sp.entity.Teacher;
import com.sp.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisTest {


    //多对多：嵌套结果
    @Test
    public void test01() {
        SqlSession session = MybatisUtils.getSqlSession();

        TeacherDao teacherDao = session.getMapper(TeacherDao.class);
        Teacher teacher = teacherDao.getTeacherById(11);
        System.out.println(teacher);
    }


    //多对多：嵌套结果
    @Test
    public void test02() {
        SqlSession session = MybatisUtils.getSqlSession();

        ClassDao classDao = session.getMapper(ClassDao.class);
        Class c = classDao.getClassById(1);
    }








}
