package com.car_sharing.project_cs.dao.impl;


import com.car_sharing.project_cs.dao.BaseDao;
import com.car_sharing.project_cs.dao.UserDao;
import com.car_sharing.project_cs.entity.User;
import com.car_sharing.project_cs.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    static final Logger logger = LogManager.getLogger();
    public static final String SELECT_PASSWORD = "SELECT pass from users WHERE mail = ?";
    public static final String INSERT_USER = "INSERT INTO users (name,surname,date_of_issue) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static UserDaoImpl instance=new UserDaoImpl();

    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        return instance;
    }

    @Override
    public boolean insert(User user) {
        boolean match=false;
        Connection connection= ConnectionPool.getInstance().getConnection();
        String nameUser=user.getName();
        String surname=user.getSurName();
        Date dateOfIssue=user.getDateOfIssue();
        Date dateOfExpirity=user.getDateOfExpirity();
        String identification=user.getIdentificationNumber();
        String pass=user.getIdentificationNumber();
        String mail=user.getMail();
        try(PreparedStatement statement= connection.prepareStatement(INSERT_USER)) {
            statement.setString(1,nameUser);
            statement.setString(2,surname);
            statement.setString(3, String.valueOf(dateOfIssue));
            statement.setString(4, String.valueOf(dateOfExpirity));
            statement.setString(5, identification);
            statement.setString(6, pass);
            statement.setString(7, mail);
            statement.executeUpdate();
            match=true;
        } catch (SQLException e) {
            logger.warn("Failed to insert into users {}",e.getMessage());;
        }
        return match;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public List<User> findAll(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean authenticate(String login, String password) {
       Connection connection=ConnectionPool.getInstance().getConnection();
        boolean match=false;
        try(PreparedStatement statement=connection.prepareStatement(SELECT_PASSWORD)) {
            statement.setString(1,login);
            ResultSet resultSet=statement.executeQuery();
            String passFromDb;
            if (resultSet.next()){
                passFromDb=resultSet.getString(1);
                match=password.equals(passFromDb);
            }
        } catch (SQLException e) {
            logger.warn("Incorrect request");
            throw new RuntimeException(e);
        }
        return match;
    }
}
