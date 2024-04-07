package com.wentong.springbug;

import com.wentong.springbug.mapper.UserMapper;
import com.wentong.springbug.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.wentong.springbug.mapper")
@RestController
public class SpringBugApplication {

    @Autowired
    UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(SpringBugApplication.class, args);
    }

    @GetMapping("user/{id}")
    public String userById(@PathVariable Long id) {
        User user = userMapper.selectById(id);
        if (user == null) {
            return "unknown user id.";
        } else {
            return user.getUsername();
        }
    }

}
