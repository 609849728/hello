package com.sp.service;

import com.github.pagehelper.PageInfo;
import com.sp.entity.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class DeptServiceTest {

    @Autowired
    private DeptService deptService;


    @Test
    public void testAdd() {
        Dept dept = new Dept();
        dept.setDeptName("大数据教学部");
        dept.setDeptDesc("千锋教育，用良心做教育");
        dept.setDeptIndex(2);
        dept.setDeptState(1);

        int i = deptService.insertSelective(dept);
        System.out.println(i);
    }




    @Test
    public void testUpdate() {
        Dept dept = new Dept();
        dept.setId(4);
        dept.setDeptDesc("小姐姐多就完事了！");
        dept.setDeptState(0);

        int i = deptService.updateByPrimaryKeySelective(dept);
        System.out.println(i);
    }


    @Test
    public void testGetById() {
        Dept dept = deptService.selectByPrimaryKey(1);
        System.out.println(dept);
    }


    @Test
    public void testDelete() {
        int i = deptService.deleteByPrimaryKey(6);
        System.out.println(i);
    }


}
