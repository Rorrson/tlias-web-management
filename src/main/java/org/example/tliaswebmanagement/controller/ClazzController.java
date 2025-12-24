package org.example.tliaswebmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.annotation.LogOperation;
import org.example.tliaswebmanagement.pojo.*;
import org.example.tliaswebmanagement.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam) {
        log.info("查询请求参数： {}", clazzQueryParam);
        PageResult pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }
    //添加班级
    @LogOperation
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        log.info("添加班级, clazz={}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }
    //查询回显
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询班级的详细信息");
        Clazz clazz  = clazzService.getInfo(id);
        return Result.success(clazz);
    }
    //更新班级信息
    @LogOperation
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("更新班级信息, {}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }
    //删除班级
    @LogOperation
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除班级,id=", id);
        clazzService.deleteById(id);
        return Result.success();
    }
    @GetMapping("/list")
    public Result list(){
        log.info("查询所有的班级数据");
        List<Clazz> clazzList = clazzService.list();
        return Result.success(clazzList);
    }



}
