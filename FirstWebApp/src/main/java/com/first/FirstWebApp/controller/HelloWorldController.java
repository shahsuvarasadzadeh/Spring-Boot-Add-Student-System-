package com.first.FirstWebApp.controller;

import com.first.FirstWebApp.entity.Student111;
import com.first.FirstWebApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;


@Controller
@RequestMapping("/students")
public class HelloWorldController {
    //
//    @GetMapping(path = "/hello")
//    public String hello(Model model) {
//        model.addAttribute("a", "salam dunya");
//        return "hello";
//    }
    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/list")
    public String getAllStudent(Model model) {

        Iterable<Student111> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "list";
    }

    @GetMapping("/new")
    public String newPage(Model model) {
        model.addAttribute("student", new Student111());
        return "details";
    }

    @PostMapping("/save")
    public RedirectView addAStudent(Student111 student111, Model model) {
        studentRepository.save(student111);
        return new RedirectView("list");
    }

    @GetMapping("/update")
    public String goToUpdate(Model model, @RequestParam Integer id){
        Optional<Student111>optionalStudent111=studentRepository.findById(id);
        if (optionalStudent111.isPresent()){
            Student111 student111=optionalStudent111.get();
            model.addAttribute("student",student111);
        }
        return "update";
    }

    @GetMapping("/delete")
    public String goToDelete(Model model,@RequestParam Integer id) {
        Optional<Student111> optionalStudent111 = studentRepository.findById(id);
        if (optionalStudent111.isPresent()) {
            Student111 student111 = optionalStudent111.get();
            model.addAttribute("student", student111);
        }
        return "delete";
    }

    @PostMapping("/delete")
    public RedirectView delete(Model model,Student111 student111){

        studentRepository.delete(student111);

        return new RedirectView("list");

    }




}
