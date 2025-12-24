package org.example.tliaswebmanagement.mapper;

import org.apache.ibatis.annotations.*;
import org.example.tliaswebmanagement.pojo.Clazz;
import org.example.tliaswebmanagement.pojo.ClazzQueryParam;
import org.example.tliaswebmanagement.pojo.Student;
import org.example.tliaswebmanagement.pojo.StudentQueryParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    @Select("select count(*) from student where clazz_id = #{id}")
    Integer countByClazzId(Integer id);
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into student(name,no,gender,phone,degree,clazz_id,id_card,is_college,address,graduation_date)" +
            "values(#{name},#{no},#{gender},#{phone},#{degree},#{clazzId},#{idCard},#{isCollege},#{address},#{graduationDate})")
    void insert(Student student);
    /**
     * 动态条件查询
     */
    List<Student> list(StudentQueryParam studentQueryParam);


    /**
     * 根据ID查询学生信息
     */
    @Select("select * from student where id = #{id}")
    Student getById(Integer id);

    void updateById(Student student);


    void deleteByIds(List<Integer> ids);
    @Update("update student set violation_count = violation_count + 1,violation_score = violation_score + #{score},update_time = now() where id = #{id}")
    void updateViolation(Integer id, Integer score);
    @MapKey("name")
    List<Map> countStudentDegreeData();
    @Select("select c.name cname , count(s.id) scount from clazz c  left join student s on s.clazz_id = c.id group by c.name order by count(s.id) desc ")
    List<Map<String,Object>> getStudentCount();
}
