package com.first.FirstWebApp.controller;

import com.first.FirstWebApp.entity.Student111;
import com.first.FirstWebApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/Student")
public class HelloWorldController {
//
//    @GetMapping(path = "/hello")
//    public String hello(Model model) {
//        model.addAttribute("a", "salam dunya");
//        return "hello";
//    }
@Autowired
private  StudentRepository studentRepository;


@GetMapping("/")
public String index(){
    return "index";
}

    @GetMapping("/list")
    public String getAllStudent(Model model){

        Iterable<Student111>students =studentRepository.findAll();
        model.addAttribute("students",students);
        return "list";
    }


}
