package com.ch05.controller;

import com.ch05.dto.User1DTO;
import com.ch05.dto.User2DTO;
import com.ch05.service.User1Service;
import com.ch05.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User2Controller {

    private final User2Service user2service;
    @Autowired
    public User2Controller(User2Service user2service) {
        this.user2service = user2service;
    }
    @GetMapping("/user2/list")
    public String list(Model model) {
        List<User2DTO> user = user2service.selectUser2s();
        model.addAttribute("user", user);
        return "/user2/list";
    }
    @GetMapping("/user2/register")
    public String register(){
        return "/user2/register";
    }
    @PostMapping("/user2/register")
    public String register(User2DTO user2DTO) { //폼으로 전송한 데이터 DTO객체에 자동 매핑
        user2service.insertUser2(user2DTO);
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(@ModelAttribute ("uid") String uid, Model model) {
        User2DTO user2DTO = user2service.selectUser2(uid);
        model.addAttribute(user2DTO);
        return "/user2/modify";
    }
    @PostMapping("/user2/modify")
    public String modify(User2DTO user2DTO){
        user2service.updateUser2(user2DTO);
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/delete")
    public String delete(@RequestParam("uid") String uid){
        user2service.deleteUser2(uid);
        return "redirect:/user2/list";
    }
}
