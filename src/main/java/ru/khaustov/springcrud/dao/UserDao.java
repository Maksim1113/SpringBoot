package ru.khaustov.springcrud.dao;

import ru.khaustov.springcrud.models.UserModel;

import java.util.List;

public interface UserDao {
    public List<UserModel> getAllUsers();

    public UserModel getUser(long id);
}
