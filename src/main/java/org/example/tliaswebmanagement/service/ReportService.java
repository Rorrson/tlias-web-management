package org.example.tliaswebmanagement.service;

import org.example.tliaswebmanagement.pojo.ClazzOption;
import org.example.tliaswebmanagement.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    /**
     * 统计各个职位的员工人数
     * @return
     */
    JobOption getEmpJobData();
    /**
     * 统计员工性别信息
     */
    List<Map> getEmpGenderData();

    List<Map> getStudentDegreeData();

    ClazzOption getStudentCountData();
}