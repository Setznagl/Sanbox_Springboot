package com.example.Aula01.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class helloController {
    @RequestMapping("/")
    public String index(@RequestParam
        (name="testString", required=false, defaultValue="World World") String parametro, Model model){
        model.addAttribute("testString", parametro);
        return "index";
    }
    // Passando parâmetro diretamente no URL http://localhost:8080/user?username=Gabriel
    @RequestMapping("/user")
    public String user(@RequestParam(name = "username" , required = false , defaultValue = "No One")
        String parametro, Model model){
        model.addAttribute("username", parametro);
        return "user";
    }
}
