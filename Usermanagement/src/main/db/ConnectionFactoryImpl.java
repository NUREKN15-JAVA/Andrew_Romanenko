package main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Author andy_
 * created 04.11.2017.
 */
public class ConnectionFactoryImpl implements ConnectionFactory {
    private String url;
    private String user;
    private String password;
    private String driver;


    public ConnectionFactoryImpl(String driver, String url, String user, String password) {
        this.driver = driver;
        this.password = password;
        this.url = url;
        this.user = user;

    }

    public ConnectionFactoryImpl(Properties properties) {
        user = properties.getProperty("connection.user");
        password = properties.getProperty("connection.password");
        url = properties.getProperty("connection.url");
        driver = properties.getProperty("connection.driver");

    }

    @Override
    public Connection createConnection() throws DatabaseException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
