package persistance.hibernateObjects.user;

/**
 * Created by r730819 on 6/29/2016.
 *
 * Interface for spring implementation.
 *
 * Used in beans
 */
public interface UserSpringService {

    public void addUser(UserEntity user);
    public void updateUser(UserEntity user);
    public UserEntity getUser(String userName, String password);
    public void removeUser(String userName, String password);
}
