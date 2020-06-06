package com.example.demo.Service.Impl;

import com.example.demo.Models.Response;
import com.example.demo.Models.Students;
import com.example.demo.Repository.StudenstRepostiry;
import com.example.demo.Service.StudentsService;
import org.springframework.stereotype.Service;

@Service
public class StudentsServiceImpl implements StudentsService {

    StudenstRepostiry studenstRepostiry;

    public StudentsServiceImpl(StudenstRepostiry studenstRepostiry) {
        this.studenstRepostiry = studenstRepostiry;
    }

    @Override
    public Response create(Students students) {
        try {
            studenstRepostiry.save(students);
        } catch (Exception e) {
            return new Response(e.getMessage(), false, 500);
        }

        return new Response("Successfully create studens", true, 200);
    }
}