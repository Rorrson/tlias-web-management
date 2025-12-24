package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.PageResult;

/**
 * 日志管理服务接口
 */
public interface LogService {

    /**
     * 日志列表分页查询
     * @param page 页码
     * @param pageSize 每页条数
     * @return 分页结果
     */
    PageResult page(Integer page, Integer pageSize);
}
