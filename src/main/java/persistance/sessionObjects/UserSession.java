package persistance.sessionObjects;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by r730819 on 6/22/2016.
 */

@Controller
@Scope("session")
public class UserSession {
    String userName;

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
