package ru.khaustov.springcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.khaustov.springcrud.dao.UserDao;
import ru.khaustov.springcrud.models.UserModel;

import java.util.List;

@Service
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

    @Override
    public void addUser(UserModel user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    public UserModel getUserByName(String username) {
        userDao.getUserByName(username);
        return null;
    }
}
