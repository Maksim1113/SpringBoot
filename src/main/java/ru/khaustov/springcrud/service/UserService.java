package ru.khaustov.springcrud.service;

import ru.khaustov.springcrud.models.UserModel;

import java.util.List;

public interface UserService {
    public List<UserModel> getAllUsers();

    public UserModel getUser(Long id);

    public void addUser(UserModel user);

    public void deleteUser(long id);
}
