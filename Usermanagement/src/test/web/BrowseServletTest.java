package test.web;

import main.User;
import main.servlet.BrowseServlet;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Author andy_
 * created 01.12.2017.
 */
public class BrowseServletTest extends MockServletTestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        createServlet(BrowseServlet.class);
    }

    @Test
    public void testBrowse() {
        User user = new User(1000L, "Andrew", "Romanenko", new Date());
        List list = Collections.singletonList(user);
        getMockUserDAO().expectAndReturn("findAll", list);
        Collection collection = (Collection) getWebMockObjectFactory().getMockSession().getAttribute("users");
        Assert.assertNotNull("Couldn't find list of users in session", collection);
        Assert.assertSame(list, collection);
    }
}
