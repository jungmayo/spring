package com.ch04.controller;

import com.ch04.dto.User2DTO;
import com.ch04.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User2Controller {

    private User2Service service;

    @Autowired
    public User2Controller(User2Service service) {
        this.service = service;
    }

    @GetMapping("/user2/register")
    public String register(){
        return "/user2/register";
    }
    @PostMapping("/user2/register")
    public String register(User2DTO dto){

        service.insertUser2(dto);

        return "redirect:/user1/list"; //get -> 다시 controller로 보냄 아래로 요청한것

    }

    @GetMapping("/user2/list")
    public String list(Model model){

        List<User2DTO> user = service.selectUser2s();
        model.addAttribute("users",users);

        return "/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(@RequestParam("uid") String uid, Model model){

        User2DTO user = service.selectUser2(uid);
        model.addAttribute(user); //타입명으로 저장 User2DTO
        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(User2DTO dto, Model model){
        service.updateUser2(dto);
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/delete")
    public String delete(){
        return "/user2/list";
    }
}
