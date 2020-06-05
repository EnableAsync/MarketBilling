package dao;

import config.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDao {
    private Connection conn;
    private Properties properties = Config.INSTANCE.getInstance();

    public Connection getConn() throws ClassNotFoundException, SQLException {
        if (conn == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    properties.getProperty("connection"),
                    properties.getProperty("user"),
                    properties.getProperty("password")
            );
        }
        return conn;
    }

    public void closeConn() throws SQLException {
        if (!(conn.isClosed())) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        BaseDao baseDao = new BaseDao();
        try {
            baseDao.getConn();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
