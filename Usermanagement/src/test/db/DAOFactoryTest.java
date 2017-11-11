package test.db;

import junit.framework.TestCase;
import main.db.DAOFactory;
import main.db.UserDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Author andy_
 * created 05.11.2017.
 */

public class DAOFactoryTest {

    private DAOFactory daoFactory;

    @Before
    public void setUp() throws Exception {
        daoFactory = DAOFactory.getInstance();
    }

    @Test
    public void testGetDAOFactory() {
        Assert.assertNotNull("DAOFactory instance is null", daoFactory);
    }

    @Test
    public void testGetUserDAO() {
        UserDAO userDAO = daoFactory.getUserDAO();
        Assert.assertNotNull("UserDAO instance is null", userDAO);
    }
}
