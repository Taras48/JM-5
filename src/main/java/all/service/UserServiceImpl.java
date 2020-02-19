package all.service;

import all.dao.*;
import all.dao.factorys.DaoFactory;
import all.model.User;
import all.utils.DaoByProprties;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl userService;
    private UserDao connect;
    DaoFactory daoFactory = DaoByProprties.getConnectionByProperties();

    private UserServiceImpl() {
        connect =  daoFactory.createUserDao();
    }

    public static UserServiceImpl getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl();
        }
        return userService;
    }
    @Override
    public void addUser(User user) {
        connect.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return connect.getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        connect.updateUser(user);
    }

    @Override
    public boolean isUserExist(Long id) {
        return connect.isUserExist(id);
    }

    @Override
    public void deleteUser(Long id) {
        connect.deleteUser(id);
    }

    @Override
    public User getUser(String name, Long password) {
        return connect.getUser(name, password);
    }
}


