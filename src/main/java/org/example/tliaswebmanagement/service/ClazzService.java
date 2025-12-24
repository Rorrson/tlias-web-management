package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.Clazz;
import org.example.tliaswebmanagement.pojo.ClazzQueryParam;
import org.example.tliaswebmanagement.pojo.Emp;
import org.example.tliaswebmanagement.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    PageResult page(ClazzQueryParam clazzQueryParam);
    void save(Clazz clazz);

    Clazz getInfo(Integer id);

    void update(Clazz clazz);
    void deleteById(Integer id);

    List<Clazz> list();
}
