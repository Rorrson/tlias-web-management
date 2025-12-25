package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;

import org.example.tliaswebmanagement.annotation.LogOperation;
import org.example.tliaswebmanagement.pojo.*;
import org.example.tliaswebmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    //学员列表查询
    @GetMapping
    public Result page(StudentQueryParam studentQueryParam) {
        log.info("查询请求参数： {}", studentQueryParam);
        PageResult pageResult = studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }
    //添加学员
    @LogOperation
    @PostMapping
    public Result save(@RequestBody Student student) {
        log.info("添加学员, student={}", student);
        studentService.save(student);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("查询学员信息, id={}", id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }
    @LogOperation
    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("更新学员信息, student={}", student);
        studentService.update(student);
        return Result.success();
    }
    @LogOperation
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("删除学员, ids={}", ids);
        studentService.delete(ids);
        return Result.success();
    }
    @LogOperation
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score) {
        studentService.violation(id, score);
        return Result.success();
    }

}
