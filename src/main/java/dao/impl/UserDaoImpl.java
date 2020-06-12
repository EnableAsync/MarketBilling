package dao.impl;

import dao.BaseDao;
import dao.UserDao;
import entity.Provider;
import entity.User;

import java.sql.*;
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

    @Override
    public int delUser(int id) throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        String sql = "delete from market_billing.users where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate();
    }

    @Override
    public int updateUser(User user) throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        String sql = "update market_billing.users set username = ?, phone = ?, address = ?, birthday = ?, role = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPhone());
        ps.setString(3, user.getAddress());
        ps.setDate(4, new Date(user.getBirthday().getTime()));
        ps.setShort(5, user.getRole());
        ps.setInt(6, user.getId());
        return ps.executeUpdate();
    }

    @Override
    public int addUser(User user) throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        String sql = "insert into market_billing.users(username, password, phone, address, birthday, role) values(?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getPhone());
        ps.setString(4, user.getAddress());
        ps.setDate(5, new Date(user.getBirthday().getTime()));
        ps.setShort(6, user.getRole());

        return ps.executeUpdate();
    }

    @Override
    public User getUserById(int id) throws SQLException, ClassNotFoundException {
        Connection conn = getConn();
        String sql = "select * from market_billing.users where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        User user = null;

        if (rs.next()) {
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
}
