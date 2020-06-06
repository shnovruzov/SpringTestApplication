package com.example.demo.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Models.Students;
import com.example.demo.Service.StudentsService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {
    private final StudentsService studentsService;

    public PageController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @PostMapping("/create")
    @ResponseBody
    public void createUser(@RequestBody Students students){
       studentsService.create(students);
    }
}