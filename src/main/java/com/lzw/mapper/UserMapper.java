package com.lzw.mapper;
import com.lzw.entity.User;
import org.apache.ibatis.annotations.Param;
/**
 * @Classname UserMapper
 * @Description TODO
 * @Version 1.0.0
 * @Created by 李志文
 * @Date 2022/1/27 16:52
 */
public interface UserMapper {
    //按照指定的用户名进行查找
    User selectName(@Param("username") String username);
    User selectNameAndPassword(@Param("username") String username,@Param("password") String password);
    void updateUser(User user);
    void insertUser(User user);
}
