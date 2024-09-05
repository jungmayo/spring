package com.ch05.controller;

import com.ch05.dto.User4DTO;
import com.ch05.service.User4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User4Controller {
    private final User4Service user4Service;

    @Autowired
    public User4Controller(User4Service user4Service) {
        this.user4Service = user4Service;
    }

    @GetMapping("/user4/list")
    public String list(Model model) {
        List<User4DTO> user = user4Service.selectUser4s();
        model.addAttribute("user", user);
        return "/user4/list";
    }
    @GetMapping("/user4/register")
    public String register(){
        return "/user4/register";
    }
    @PostMapping("/user4/register")
    public String register(User4DTO dto){
        user4Service.insertUser4(dto);
        return "redirect:/user4/list";
    }

    @GetMapping("/user4/modify")
    public String modify(@RequestParam("uid") String uid, Model model){
        User4DTO user4DTO = user4Service.selectUser4(uid);
        model.addAttribute(user4DTO);
        return "/user4/modify";
    }
    @PostMapping("/user4/modify")
    public String modify(User4DTO dto){
        user4Service.updateUser4(dto);
        return "redirect:/user4/list";
    }
    @GetMapping("/user4/delete")
    public String delete(@RequestParam("uid") String uid){
        user4Service.deleteUser4(uid);
        return "redirect:/user4/list";
    }
}
