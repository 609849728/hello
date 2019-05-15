package com.sp.mapper;

import com.sp.entity.Emp;
import com.sp.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RootMapper {

    /*
    选择好角色名称后，点击添加授权人员
    传一个角色的id，然后就不显示该角色的所有用户，避免了重复添加
     */
    List<Emp> getListEmpByRoleId(Integer roleId);


    //授权之前，先把已经授权了的用户删除掉
    int batchDelete(Integer[] ids);

    //批量授权（角色id，用户id）
    int batchRoot(@Param("roleId") Integer roleId,@Param("ids") Integer[] ids);


    //获取目录树
    List<Map<String,Object>> getMenuTree(Integer roleId);


    //授权菜单之前，先把该角色授权了的菜单删除掉
    int batchDeleteMenu(Integer id);

    //批量授权菜单（角色id，菜单id）
    int batchRootMenu(@Param("roleId") Integer roleId,@Param("ids") Integer[] ids);



    //查询类型为用户
    List<Emp> getEmpListByRoleId(Integer roleId);

    //查询类型为菜单
    List<Menu> getMenuListByRoleId(Integer roleId);


    //删除中间表的用户
    int deleteEmp(Integer reId);

    //删除中间表的菜单
    int deleteMenu(Integer rmId);

}
