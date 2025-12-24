package org.example.tliaswebmanagement.controller;

import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志管理控制器
 */
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 日志列表分页查询
     */
    @GetMapping("/page")
    public Result page(Integer page, Integer pageSize) {
        PageResult pageResult = logService.page(page, pageSize);
        return Result.success(pageResult);
    }
}
