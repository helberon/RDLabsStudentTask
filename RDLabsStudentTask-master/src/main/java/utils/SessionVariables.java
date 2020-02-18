package utils;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;

//https://johnfergusonsmart.com/sharing-state-steps-serenity-bdd/

@Getter
@Slf4j
public enum SessionVariables {

    DATE_OF_BIRTH,
    FIRST_NAME,
    LAST_NAME,
    MIDDLE_NAME,
    FILTER_USERS_WINDOW;

    SessionVariables() {
        this.var = name();
    }

    private final String var;

    public void put(Object value) {
        log.info(String.format("Putting to session variables %s - %s", var, value));
        Serenity.getCurrentSession().put(var, value);
    }

    public <T> T get() {
        log.info(String.format("Getting from session variables %s", var));
        return (T) Serenity.getCurrentSession().get(var);
    }

}
