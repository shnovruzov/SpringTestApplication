package com.example.demo.Service;

import com.example.demo.Models.Response;
import com.example.demo.Models.Students;

public interface StudentsService {
    Response create(Students students);

    Iterable<Students> findAll();

    Students findById(Long id);

    Response deleteById(Long id);

    Response update(Students students);
}
