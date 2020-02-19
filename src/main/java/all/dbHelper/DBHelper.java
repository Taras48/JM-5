package all.dbHelper;

import all.model.User;

import all.utils.PropertyReader;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static DBHelper dbHelper;

    private DBHelper() {
    }

    public static DBHelper getInstance() {
        if (dbHelper == null) {
            return dbHelper = new DBHelper();
        }
        return dbHelper;
    }

    public Connection getConnection() {
        try {
            Driver driver = (Driver) Class.forName(PropertyReader.getProperty("driver")).newInstance();
            DriverManager.registerDriver(driver);
            return DriverManager.getConnection(PropertyReader.getProperty("base"));
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    public SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.setProperty("hibernate.dialect", PropertyReader.getProperty("dialect"));
        configuration.setProperty("hibernate.connection.driver_class", PropertyReader.getProperty("driver"));
        configuration.setProperty("hibernate.connection.url", PropertyReader.getProperty("url"));
        configuration.setProperty("hibernate.connection.username", PropertyReader.getProperty("username"));
        configuration.setProperty("hibernate.connection.password", PropertyReader.getProperty("password"));
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
