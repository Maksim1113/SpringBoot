package ru.khaustov.springcrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.khaustov.springcrud.models.UserModel;
import ru.khaustov.springcrud.service.UserService;

import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/start")
    public String start(){
        return "start";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){
        List<UserModel> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "getUsers";
    }

    @GetMapping("/users/{id}")
    public String user(@ModelAttribute("user") UserModel edUser, Model model){
        UserModel user = userService.getUser(edUser.getId());
        model.addAttribute("user", user);
        return "newUser";
    }


    @GetMapping("/users/new")
    public String setNewUser(Model model){
        model.addAttribute("user", new UserModel());
        return "newUser";

    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") UserModel user){
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/registration")
    public String regNewUser(Model model){
        model.addAttribute("user", new UserModel());
        return "registration";

    }
    @PostMapping("/users/registration")
    public String regUser(@ModelAttribute("user") UserModel user){
        userService.addUser(user);
        return "redirect:/start";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@ModelAttribute("user") UserModel user){
        userService.deleteUser(user.getId());
        return "redirect:/users";
    }


}
