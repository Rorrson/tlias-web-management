package org.example.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.tliaswebmanagement.mapper.StudentMapper;
import org.example.tliaswebmanagement.pojo.*;
import org.example.tliaswebmanagement.pojo.Student;
import org.example.tliaswebmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    public PageResult page(StudentQueryParam studentQueryParam) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        //2. 执行查询
        List<Student> studentList = studentMapper.list(studentQueryParam);
        //3. 封装分页结果
        Page<Student> p = (Page<Student>)studentList;
        return new PageResult(p.getTotal(), p.getResult());
    }
    @Transactional
    @Override
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.insert(student);
    }
    @Override
    public Student getInfo(Integer id) {
        return studentMapper.getById(id);
    }
    @Transactional
    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateById(student);
    }

    @Transactional
    @Override
    public void delete(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }
    @Transactional
    @Override
    public void violation(Integer id, Integer score) {
        studentMapper.updateViolation(id, score);
    }
    
}
