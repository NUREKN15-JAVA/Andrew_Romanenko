package main.db;

/**
 * Author andy_
 * created 05.11.2017.
 */
public class DAOFactoryImpl extends DAOFactory {

    @Override
    public UserDAO getUserDAO() {

        HsqldbUserDAO userDAO;
        try {

            userDAO = new HsqldbUserDAO();
            userDAO.setConnectionFactory(getConnectionFactory());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userDAO;
    }
}
