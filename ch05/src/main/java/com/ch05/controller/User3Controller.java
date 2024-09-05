package com.ch05.controller;

import com.ch05.dto.User3DTO;
import com.ch05.service.User3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User3Controller {

    private final User3Service user3service;
    @Autowired
    public User3Controller(User3Service user3service) {
        this.user3service = user3service;
    }
    @GetMapping("/user3/list")
    public String list(Model model) {
        List<User3DTO> user = user3service.selectUser3s();
        model.addAttribute("user", user);
        return "/user3/list";
    }
    @GetMapping("/user3/register")
    public String register(){
        return "/user3/register";
    }
    @PostMapping("/user3/register")
    public String register(User3DTO user3DTO) { //폼으로 전송한 데이터 DTO객체에 자동 매핑
        user3service.insertUser3(user3DTO);
        return "redirect:/user3/list";
    }

    @GetMapping("/user3/modify")
    public String modify(@ModelAttribute ("uid") String uid, Model model) {
        User3DTO user3DTO = user3service.selectUser3(uid);
        model.addAttribute(user3DTO);
        return "/user3/modify";
    }
    @PostMapping("/user3/modify")
    public String modify(User3DTO user3DTO){
        user3service.updateUser3(user3DTO);
        return "redirect:/user3/list";
    }

    @GetMapping("/user3/delete")
    public String delete(@RequestParam("uid") String uid){
        user3service.deleteUser3(uid);
        return "redirect:/user3/list";
    }
}
