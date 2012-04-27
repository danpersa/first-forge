package ro.danix.bean;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import ro.danix.model.entity.User;
import ro.danix.model.service.LoggedIn;

public class MyBean {

    @MaxNumber
    @Inject
    int maxNumber;
    private int maximum;
    @Random
    @Inject
    Instance<Integer> randomInt;
    @Inject
    @LoggedIn
    User currentUser;
}