package main.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Author andy_
 * created 01.11.2017.
 */


public abstract class DAOFactory {
    protected static final String USER_DAO = "user.dao";
    private static String DAO_FACTORY = "dao.factory";
    protected static Properties properties;
    private static DAOFactory instance;

    static {
        InputStream inputStream;
        properties = new Properties();
        try {
            inputStream = new FileInputStream("src/main/resources/settings.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static synchronized DAOFactory getInstance() {
        if (instance == null) {
            Class factoryClass = null;
            try {
                factoryClass = Class.forName(properties.getProperty(DAO_FACTORY));
                instance = (DAOFactory) factoryClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    protected DAOFactory() {

    }

    protected ConnectionFactory getConnectionFactory() {
        return new ConnectionFactoryImpl(properties);
    }

    public static void init(Properties prop) {
        properties = prop;
        instance = null;
    }

    public abstract UserDAO getUserDAO();
}
