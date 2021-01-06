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
    public String addUser() {
        return userDao.addUser();
    }

    @Override
    public String updateUser(long id) {
        return userDao.updateUser(id);
    }

    @Override
    public String deleteUser(long id) {
        return deleteUser(id);
    }
}
