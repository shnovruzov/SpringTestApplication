package com.example.demo.Controller;

import com.example.demo.Models.Response;
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
    public Response createUser(@RequestBody Students students) {
        return studentsService.create(students);
    }

    @GetMapping("/all")
    public Iterable<Students> all() {
        return studentsService.findAll();
    }

    @GetMapping("/findStudent/{id}")
    public Students findUser(@PathVariable String id) {
        return studentsService.findById(Long.valueOf(id));
    }

    @DeleteMapping("/delete/{id}")
    public Response deleteStudent(@PathVariable String id) {
        return studentsService.deleteById(Long.valueOf(id));
    }
}