package ru.khaustov.springcrud.dao;

import org.springframework.stereotype.Component;
import ru.khaustov.springcrud.models.UserModel;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImp implements UserDao{

    List<UserModel> users;
    private long id = 0;

    public UserDaoImp() {
        users = new ArrayList<>();
        users.add(new UserModel(++id, "Fill", (byte)34));
        users.add(new UserModel(++id, "Fill", (byte)34));
    }

    @Override
    public List<UserModel> getAllUsers(){
        return users;
    }

    @Override
    public UserModel getUser(long id){
        UserModel user = users.stream().filter(x -> x.getId() == id)
                .findAny().orElse(null);
        return user;
    }

    @Override
    public void addUser(UserModel user) {
        user.setId(++id);
        users.add(user);

    }

    @Override
    public void updateUser(long id, UserModel upUser) {
        getUser(id).setName(upUser.getName());
        getUser(id).setAge(upUser.getAge());
    }

    @Override
    public void deleteUser(long id) {
        users.removeIf(x -> x.getId() == id);
    }
}
