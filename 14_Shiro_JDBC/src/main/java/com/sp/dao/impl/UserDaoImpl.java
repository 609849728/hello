package com.sp.dao.impl;

import com.sp.dao.UserDao;
import com.sp.utils.JDBCUtils;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserDaoImpl implements UserDao {


    @Override
    public String getPassword(String username) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();

            //根据用户名查询密码，这样既能判断用户是否存在，也能判断密码是否正确
            String sql = "SELECT password FROM t_user WHERE username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);

            //执行SQL
            rs = ps.executeQuery();

            //处理返回结果
            if(rs.next()) {
                return rs.getString(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭释放资源
            JDBCUtils.close(rs,ps,conn);
        }

        return null;
    }


    @Override
    public Set<String> getListRoleByUser(String username) {
        Set<String> set = new HashSet<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();

            //3张表关联查询
            String sql = "SELECT r.role_name FROM t_user u LEFT JOIN t_role_user ru ON (u.id = ru.user_id) LEFT JOIN t_role r ON (r.id = ru.role_id) WHERE u.username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);

            //执行SQL
            rs = ps.executeQuery();

            //处理返回结果
            while(rs.next()) {
                set.add(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭释放资源
            JDBCUtils.close(rs,ps,conn);
        }

        return set;
    }


    @Override
    public Set<String> getListPermitByUser(String username) {
        Set<String> set = new HashSet<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();

            //5张表关联查询
            String sql = "SELECT p.permit_name FROM t_user u " +
                         "LEFT JOIN t_role_user ru ON (u.id = ru.user_id) " +
                         "LEFT JOIN t_role r ON (r.id = ru.role_id) " +
                         "LEFT JOIN t_role_permit rp ON (r.id=rp.role_id) " +
                         "LEFT JOIN t_permit p ON (p.id=rp.permit_id) " +
                         "WHERE u.username = ? GROUP BY p.permit_name";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);

            //执行SQL
            rs = ps.executeQuery();

            //处理返回结果
            while(rs.next()) {
                set.add(rs.getString(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭释放资源
            JDBCUtils.close(rs,ps,conn);
        }

        return set;
    }



}
