package com.first.FirstWebApp.controller;

import com.first.FirstWebApp.entity.Course;
import com.first.FirstWebApp.entity.Student111;
import com.first.FirstWebApp.repository.CourseRepository;
import com.first.FirstWebApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/students")
public class StudentController {
    //
//    @GetMapping(path = "/hello")
//    public String hello(Model model) {
//        model.addAttribute("a", "salam dunya");
//        return "hello";
//    }
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;


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
        model.addAttribute("student111", new Student111());
        Iterable<Course> courses = courseRepository.findAll();
        model.addAttribute("allCourses", courses);
        return "add";
    }

    @PostMapping("/save")
    public RedirectView addAStudent(@Valid Student111 student,  BindingResult bindingResult,Model model  ) {

            if (bindingResult.hasErrors()) {
              model.addAttribute("student", new Student111());
                Iterable<Course> courses = courseRepository.findAll();
                model.addAttribute("allCourses", courses);
                return new RedirectView( "add");
            }
            studentRepository.save(student);
            return new RedirectView ("list");
    }

    @GetMapping("/update")
    public String goToUpdate(Model model, @RequestParam Integer id) {
        Optional<Student111> optionalStudent111 = studentRepository.findById(id);
        if (optionalStudent111.isPresent()) {
            Student111 student111 = optionalStudent111.get();
            model.addAttribute("student", student111);

            Iterable<Course> courses = courseRepository.findAll();
            model.addAttribute("allCourses", courses);

        }
        return "update";
    }

    @GetMapping("/delete")
    public String goToDelete(Model model, @RequestParam Integer id) {
        Optional<Student111> optionalStudent111 = studentRepository.findById(id);
        if (optionalStudent111.isPresent()) {
            Student111 student111 = optionalStudent111.get();
            model.addAttribute("student", student111);
        }
        return "delete";
    }

    @PostMapping("/delete")
    public RedirectView delete(Model model, Student111 student111) {

        studentRepository.delete(student111);

        return new RedirectView("list");

    }

    @GetMapping("/name/{name}")
    public String getStudentById(Model model, @PathVariable String name) {
        List<Student111> student111s = studentRepository.findByName(name);
        model.addAttribute("students", student111s);
        return "list";
    }
    @GetMapping("/name")
    public String getStudentById1(Model model, @RequestParam String name) {
        List<Student111> student111s = studentRepository.findByName(name);
        model.addAttribute("students", student111s);
        return "list";
    }

    @GetMapping("/surname/{surname}")
    public String getStudentBysurname(Model model, @PathVariable String surname) {
        List<Student111> student111s = studentRepository.getStudentBySurname(surname);
        model.addAttribute("students", student111s);
        return "list";
    }

    @GetMapping("/surname")
    public String getStudentBysurname1(Model model, @RequestParam String surname) {
        List<Student111> student111s = studentRepository.getStudentBySurname(surname);
        model.addAttribute("students", student111s);
        return "list";
    }


}
