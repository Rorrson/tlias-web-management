package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.example.tliaswebmanagement.pojo.Clazz;
import org.example.tliaswebmanagement.pojo.ClazzQueryParam;

import java.util.List;

@Mapper
public interface ClazzMapper {

    List<Clazz> list(ClazzQueryParam clazzQueryParam);
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into clazz(name,room,begin_date,end_date,master_id,subject)" +
            "values(#{name},#{room},#{beginDate},#{endDate},#{masterId},#{subject})")
    void insert(Clazz clazz);
    Clazz getById(Integer id);
    void updateById(Clazz clazz);
    void deleteById(Integer id);
    @Select("select * from clazz")
    List<Clazz> findAll();
}
