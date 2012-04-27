package ro.danix.bean;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;

/**
 *
 * @author dix
 */
@RequestScoped
@Named
@Default
public class AnotherBean {
    
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
