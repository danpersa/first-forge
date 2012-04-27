package ro.danix.model.service;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import ro.danix.model.dto.Credentials;
import ro.danix.model.entity.User;

/**
 *
 * @author dix
 */
@Named
@SessionScoped
public class LoginService implements Serializable {

    @Inject
    private Credentials credentials;
    private User user = new User();

    public void login() {
        credentials.setUsername("username");
        credentials.setPassword("password");
        user.setUsername("username");
        user.setPassword("password");
    }

    public boolean isAuthenticated() {
        return user != null;
    }

    public void logout() {
        user = null;
    }

    @Produces
    @LoggedIn
    User getCurrentUser() {
        return user;
    }
}
