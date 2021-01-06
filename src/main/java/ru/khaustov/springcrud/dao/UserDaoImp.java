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
}
