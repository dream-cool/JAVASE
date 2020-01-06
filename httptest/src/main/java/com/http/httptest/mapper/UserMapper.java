package com.http.httptest.mapper;

import com.http.httptest.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * @author ：clt
 * @Date ：Created in 15:50 2019/10/8
 */
@Mapper
public interface UserMapper {

    @Select("select username user,password pass from user where username = #{user} and password = #{pass}")
    User login(String user, String pass);


}
