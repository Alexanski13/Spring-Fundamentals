package softuni.battleships2.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import softuni.battleships2.models.entities.User;

@Component
@SessionScope
public class LoggedUser {

    private long id;

    private String fullName;

    public void login(User user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
    }

    public void logout() {
        this.id = 0;
        this.fullName = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
