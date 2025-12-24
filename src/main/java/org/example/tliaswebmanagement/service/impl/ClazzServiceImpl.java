package org.example.tliaswebmanagement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.tliaswebmanagement.mapper.ClazzMapper;
import org.example.tliaswebmanagement.mapper.StudentMapper;
import org.example.tliaswebmanagement.pojo.Clazz;
import org.example.tliaswebmanagement.pojo.ClazzQueryParam;
import org.example.tliaswebmanagement.pojo.PageResult;
import org.example.tliaswebmanagement.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private StudentMapper studentMapper;
    public PageResult page(ClazzQueryParam clazzQueryParam) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        //2. 执行查询
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);
        //3. 封装分页结果
        Page<Clazz> p = (Page<Clazz>)clazzList;
        return new PageResult(p.getTotal(), p.getResult());
    }
    @Transactional
    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }
    @Override
    public Clazz getInfo(Integer id) {
        return clazzMapper.getById(id);
    }
    @Transactional
    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateById(clazz);
    }
    @Transactional
    @Override
    public void deleteById(Integer id) {
        //查询班级下是否有学员
        Integer count = studentMapper.countByClazzId(id);
        if (count > 0) {
            throw new RuntimeException("班级下有学员，不能删除");
        }
        clazzMapper.deleteById(id);
    }
    @Override
    public List<Clazz> list() {
        return clazzMapper.findAll();
    }

}
