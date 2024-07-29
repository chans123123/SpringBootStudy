package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//뷰 페이지 만들기
@Controller //컨트롤러 선언
public class FirstController {
    @GetMapping("/hi")
    public String niceToMeetYou(Model model) { //컨트롤러에 모델 추가하기
        model.addAttribute("username", "찬영"); //모델에서 변수 추가하기
        return "greetings"; //컨트롤러에서 greetings.mustache 받아오기
    }// end niceToMeetYou
    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("nickname", "찬영");
        return "goodbye";
    }
}
