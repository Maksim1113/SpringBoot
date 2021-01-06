package ru.khaustov.springcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.khaustov.springcrud.dao.UserDao;
import ru.khaustov.springcrud.models.UserModel;

import java.util.List;

public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserModel> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public UserModel getUser(Long id) {
        return userDao.getUser(id);
    }
}
