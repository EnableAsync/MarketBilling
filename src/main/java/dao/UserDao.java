package dao;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public User getUserByName(String name) throws SQLException, ClassNotFoundException;

    public List<User> getAllUsers() throws SQLException, ClassNotFoundException;
}
