package org.example.tliaswebmanagement.service.impl;

import org.example.tliaswebmanagement.mapper.EmpMapper;
import org.example.tliaswebmanagement.mapper.StudentMapper;
import org.example.tliaswebmanagement.pojo.ClazzOption;
import org.example.tliaswebmanagement.pojo.JobOption;
import org.example.tliaswebmanagement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }
    @Override
    public List<Map> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }
    @Override
    public List<Map> getStudentDegreeData() {
        return studentMapper.countStudentDegreeData();
    }
    @Override
    public ClazzOption getStudentCountData() {
        List<Map<String, Object>> countList = studentMapper.getStudentCount();
        if (!CollectionUtils.isEmpty(countList)) {
            List<String> clazzList = countList.stream()
                    .map(map -> (String) map.get("cname"))
                    .toList();

            List<Long> dataList = countList.stream()
                    .map(map -> ((Number) map.get("scount")).longValue())
                    .toList();

            return new ClazzOption(clazzList, dataList);
        }
        return null;
    }


}