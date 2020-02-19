package all.dao;

import all.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
    public void addUser(User user);
    public boolean isUserExist(Long id);
    public void updateUser(User user);
    public void deleteUser(Long id);
    public User getUser(Long id);
    public User getUser(String name, Long password);
}
