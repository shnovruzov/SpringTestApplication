package com.example.demo.Service.Impl;

import com.example.demo.Exception.CustomException;
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
            return new Response(e.getMessage(), false);
        }
        return new Response("Successfully create student", true);
    }

    @Override
    public Iterable<Students> findAll() {
        Iterable<Students> students = studenstRepostiry.findAll();
        return students;
    }

    @Override
    public Students findById(Long id) {
          try {
              return studenstRepostiry.findById(id).get();
          }catch (Exception e){
              throw new CustomException("Student not found");
          }
    }

    @Override
    public Response deleteById(Long id) {
        try {
            studenstRepostiry.deleteById(id);
        }catch (Exception e){
            throw new CustomException("Student not found");
        }
        return new Response("Successfully create student", true);
    }

    @Override
    public Response update(Students students) {
        return null;
    }
}