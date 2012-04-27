package ro.danix.bean;

import ro.danix.bean.MyBean;
import ro.danix.model.entity.User;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.Test;
import org.junit.runner.RunWith;
import ro.danix.model.dto.Credentials;
import ro.danix.model.service.LoggedIn;
import ro.danix.model.service.LoginService;
import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class MyBeanTest {

    @Inject
    private MyBean myBean;
    @Inject
    private LoginService loginService;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar").addPackage("ro.danix.bean")
                .addClass(LoggedIn.class).addClass(LoginService.class)
                .addClass(User.class).addClass(Credentials.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testIsDeployed() {
        assertNotNull(myBean);
        assertTrue(myBean.maxNumber == 100);
        assertNotNull(myBean.randomInt.get());

        assertNotNull(loginService);
        loginService.login();

        assertTrue(loginService.isAuthenticated());

        assertNotNull(myBean.currentUser);
        assertEquals("username", myBean.currentUser.getUsername());
    }
}
