package org.example.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.tliaswebmanagement.mapper.OperateLogMapper;
import org.example.tliaswebmanagement.pojo.OperateLog;
import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.service.EmpService;
import org.example.tliaswebmanagement.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 日志管理服务实现类
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Autowired
    private EmpService empService;

    @Override
    public PageResult page(Integer page, Integer pageSize) {
        // 设置分页参数
        PageHelper.startPage(page, pageSize);
        // 查询日志列表
        List<OperateLog> logList = operateLogMapper.list();
        // 转换为Page对象
        Page<OperateLog> p = (Page<OperateLog>) logList;
        // 封装分页结果
        return new PageResult(p.getTotal(), p.getResult());
    }
}
