package taller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.google.appengine.tools.development.testing.LocalUserServiceTestConfig;
import com.example.taller.AppengineUnitTestServlet;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

public class AppengineUnitTestServletTest {
    
	private  AppengineUnitTestServlet appengineUnitTestServlet;
	
	private final LocalServiceTestHelper helper =
		      new LocalServiceTestHelper(new LocalUserServiceTestConfig())
		          .setEnvIsLoggedIn(true)
		          .setEnvAuthDomain("localhost")
		          .setEnvEmail("test@localhost");

    @Before
    public void setupGuestBookServlet() {
		helper.setUp();
		appengineUnitTestServlet = new AppengineUnitTestServlet();
    }

    @After
	public void tearDownHelper() {
		helper.tearDown();
	}
	
    @Test
    public void testDoGet() throws IOException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();

        when(response.getWriter()).thenReturn(new PrintWriter(stringWriter));

        appengineUnitTestServlet.doGet(request, response);

        User currentUser = UserServiceFactory.getUserService().getCurrentUser();
    
        assertEquals(currentUser.getEmail(), stringWriter.toString());
   }

}
