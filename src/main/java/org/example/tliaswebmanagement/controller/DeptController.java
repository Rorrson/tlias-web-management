package org.example.tliaswebmanagement.controller;


import org.example.tliaswebmanagement.annotation.LogOperation;
import org.example.tliaswebmanagement.pojo.Dept;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/depts")
/**
 * 部门管理控制器
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询部门列表
     */
    @GetMapping
    public Result list(){
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
    /**
     * 根据id删除部门 - delete http://localhost:8080/depts?id=1
     */
    @LogOperation
    @DeleteMapping
    public Result delete(Integer id){
        System.out.println("根据id删除部门, id=" + id);
        deptService.deleteById(id);
        return Result.success();
    }
    /**
     * 新增部门 - POST http://localhost:8080/depts   请求参数：{"name":"研发部"}
     */
    @LogOperation
    @PostMapping
    public Result save(@RequestBody Dept dept){
        System.out.println("新增部门, dept=" + dept);
        deptService.save(dept);
        return Result.success();
    }
    /**
     * 根据ID查询 - GET http://localhost:8080/depts/1
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        System.out.println("根据ID查询, id=" + id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    /**
     * 修改部门 - PUT http://localhost:8080/depts  请求参数：{"id":1,"name":"研发部"}
     */
    @LogOperation
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        System.out.println("修改部门, dept=" + dept);
        deptService.update(dept);
        return Result.success();
    }
}