package ru.khaustov.springcrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StartController {
    @GetMapping("/tt")
    public String getStart(Model model){
        List<String> message = new ArrayList<>();
        message.add("Hello my dear friend");
        message.add("You are in this page");
        model.addAttribute("mess", message);
        return "start";
    }
}
