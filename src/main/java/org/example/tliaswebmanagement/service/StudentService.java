package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.ClazzOption;
import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.pojo.Student;
import org.example.tliaswebmanagement.pojo.StudentQueryParam;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface StudentService {
    PageResult page(StudentQueryParam studentQueryParam);

    void save(Student student);

    Student getInfo(Integer id);

    void update(Student student);

    void delete(List<Integer> ids);

    void violation(Integer id, Integer score);

    
}
