package com.ch04.controller;

import com.ch04.dto.User1DTO;
import com.ch04.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User1Controller {


    private User1Service service;

    @Autowired
    public User1Controller(User1Service service) {
        this.service = service;
    }

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }

    @PostMapping ("/user1/register")
    public String register(User1DTO dto){ //req.getparameter(dispatcher servlet이 )
        System.out.println(dto);

        //등록
        service.insertUser1(dto);

        // 리다이렉트
        return "redirect:/user1/list";
    }

    @GetMapping ("/user1/list")
    public String list(Model model){

        //조회
        List<User1DTO> users = service.selectUser1s();
        System.out.println(users);

        // 모델참조(Controller 데이터를 View에서 참조)
        model.addAttribute("users", users);

        return "/user1/list";
    }

    @GetMapping("/user1/modify")
    public String modify(@RequestParam("uid") String uid, Model model){ //requestParam 생략 가능(=get parameter)

        System.out.println("uid : " + uid);

        //수정 회원 조회
        User1DTO user = service.selectUser1(uid);

        //모델참조
        model.addAttribute(user); //(user)만 되어있을때 타입명으로 저장(소문자 시작) => user1DTO //아니면 ("user" user) 이렇게도 가능

        return "/user1/modify";
    }
    @PostMapping("/user1/modify")
    public String modify(@ModelAttribute User1DTO dto){ //@ModelAttribute 생략가능

        System.out.println(dto);

        //수정
        service.updateUser1(dto);

        //모델참조
        //model.addAttribute(dto);

        //리다이렉트
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/delete")
    public String delete(@RequestParam("uid") String uid){

        System.out.println("uid : " + uid);

        service.deleteUser1(uid);

        return "redirect:/user1/list";
    }
}
