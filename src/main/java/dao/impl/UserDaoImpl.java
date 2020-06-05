package dao.impl;

import dao.BaseDao;
import dao.UserDao;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User getUserByName(String name) throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        String sql = "select * from market_billing.users where username = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        User user = null;

        while (rs.next()) {
            user = User.builder()
                    .id(rs.getInt("id"))
                    .username(rs.getString("username"))
                    .password(rs.getString("password"))
                    .phone(rs.getString("phone"))
                    .address(rs.getString("address"))
                    .birthday(rs.getDate("birthday"))
                    .role(rs.getShort("role"))
                    .build();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        String sql = "select * from market_billing.users";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<User> userList = new ArrayList<>();

        while (rs.next()) {
            User user = User.builder()
                    .id(rs.getInt("id"))
                    .username(rs.getString("username"))
                    .password(rs.getString("password"))
                    .phone(rs.getString("phone"))
                    .address(rs.getString("address"))
                    .birthday(rs.getDate("birthday"))
                    .role(rs.getShort("role"))
                    .build();
            userList.add(user);
        }
        return userList;
    }
}
