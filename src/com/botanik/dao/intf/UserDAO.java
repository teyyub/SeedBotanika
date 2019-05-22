package com.botanik.dao.intf;

 
import com.botanik.model.User;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author teyyub , Feb 13, 2018 , 4:54:32 PM
 */
public interface UserDAO {

    public User user(String username, String password);

    public boolean checkUser(String username);
    
    public void createUser(User user);
    
    List<User> loadUsers();
    
    void deleteUser(Number userId);
    
    public Collection<User> users(String userName);
    
    public void resetPassword(Number id, String password);
}
