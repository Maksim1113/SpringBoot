package ru.khaustov.springcrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.khaustov.springcrud.models.UserModel;
import ru.khaustov.springcrud.service.UserService;
import ru.khaustov.springcrud.service.UserServiceImp;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public String getAllUsers(Model model){
        List<UserModel> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "getUsers";
    }

    @GetMapping("/{id}")
    public String user(@PathVariable("id") long id, Model model){
        UserModel userModel = userService.getUser(id);
        model.addAttribute("user", userModel);
        return "getUser";

    }


}
