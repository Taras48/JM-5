package all.service;

import all.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public List<User> getAllUsers();
    public void updateUser(User user);
    public boolean isUserExist(Long id);
    public void deleteUser(Long id);
    public  User getUser(String name, Long password);
}
