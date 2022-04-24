package com.sherry.mapper;

import com.sherry.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface StudentMapper {
    public List<Student> getStudents();
}
