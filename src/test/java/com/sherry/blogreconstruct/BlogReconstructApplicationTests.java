package com.sherry.blogreconstruct;

import com.sherry.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogReconstructApplicationTests {
    @Autowired
    StudentMapper mapper;
    @Test
    void contextLoads() {
        System.out.println(mapper.getStudents());
    }

}
