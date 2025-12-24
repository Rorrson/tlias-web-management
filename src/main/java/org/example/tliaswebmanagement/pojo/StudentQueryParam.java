package org.example.tliaswebmanagement.pojo;
import lombok.Data;
@Data
public class StudentQueryParam {
    private Integer page = 1; //页码
    private Integer pageSize = 10; //每页展示记录数
    private String name;
    private Integer degree;
    private Integer clazzId;

}
