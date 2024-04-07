package com.wentong.springbug.mapper;

import com.wentong.springbug.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper{
    @Select("select * from user where id = 8")
    User selectById(Long id);

}
