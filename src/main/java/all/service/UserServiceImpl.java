package all.service;

import all.dao.UserDaoImpl;
import all.dbHelper.DBHelper;
import all.model.User;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private SessionFactory sessionFactory;

    private static UserServiceImpl userService;

    private UserServiceImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserServiceImpl getInstance() {
        if (userService == null) {
            userService = new UserServiceImpl(DBHelper.getSessionFactory());
        }
        return userService;
    }

    @Override
    public void addUser(User user) {
        new UserDaoImpl(sessionFactory.openSession()).addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return new UserDaoImpl(sessionFactory.openSession()).getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        new UserDaoImpl(sessionFactory.openSession()).updateUser(user);
    }

    @Override
    public boolean isUser(Long id) {
        return  new UserDaoImpl(sessionFactory.openSession()).isUser(id);
    }

    @Override
    public void deleteUser(Long id) {
          new UserDaoImpl(sessionFactory.openSession()).deleteUser(id);
    }
}


