package com.sp.dao;

import com.sp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


//映射文件中select标签的id对应接口中的方法名，返回值和参数也要一一对应，namespace是此接口的全类名
public interface UserDao {

    /*
    测试方法中含有多个参数的情况
    多个参数，Mybatis会自动封装成Map集合，Map的key就是param1，以此类推
    可以通过${key}获取值，也可以直接通过形参的名称
     */
    User login(String user,String pass);

    //测试方法参数为Map集合的情况
    User login02(Map<String,Object> map);

    //为参数名添加别名，通过@Param注解实现
    User login03(@Param("u")String user,@Param("p")String pass);

    //主键回填，返回主键
    Integer addUser(User user);

    //如果参数不是对象而是Map集合时，主键如何回填？key必须是Object或者String类型，value必须是Object或者Integer类型，否则无法回填
    Integer addUser02(Map<String, Object> map);

}
