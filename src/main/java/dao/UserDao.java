package dao;

import entity.Provider;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public User getUserByName(String name) throws SQLException, ClassNotFoundException;

    public List<User> getAllUsers() throws SQLException, ClassNotFoundException;

    public int delUser(int id) throws SQLException, ClassNotFoundException;

    public int updateUser(User user) throws SQLException, ClassNotFoundException;

    public int addUser(User user) throws SQLException, ClassNotFoundException;

    public User getUserById(int id) throws SQLException, ClassNotFoundException;
}
