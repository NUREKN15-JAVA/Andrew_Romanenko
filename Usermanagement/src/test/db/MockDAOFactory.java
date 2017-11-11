package test.db;

import com.mockobjects.dynamic.Mock;
import main.db.DAOFactory;
import main.db.UserDAO;

/**
 * Author andy_
 * created 07.11.2017.
 */



public class MockDAOFactory extends DAOFactory {
    private Mock mockUserDAO;

    public MockDAOFactory() {
        mockUserDAO = new Mock(UserDAO.class);
    }

    public Mock getMockUserDAO() {
        return mockUserDAO;
    }

    @Override
    public UserDAO getUserDAO() {
        return (UserDAO) mockUserDAO.proxy();
    }
}
