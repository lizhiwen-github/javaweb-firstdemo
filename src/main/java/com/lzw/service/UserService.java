package com.lzw.service;
import com.lzw.entity.User;
import com.lzw.mapper.UserMapper;
import com.lzw.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
/**
 * @Classname UserService
 * @Description TODO
 * @Version 1.0.0
 * @Created by 李志文
 * @Date 2022/1/27 17:49
 */
public class UserService {
    /**
     * @param user 用户实体类
     * @return com.lzw.entity.User
     * @author 李志文
     * @date 2022/1/28 10:07
     * @description: TODO 验证用户登录信息是否正确
     */
    public static User selectUsernameAndPassword(User user){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.selectNameAndPassword(user.getUsername(), user.getPassword());
        sqlSession.close();
        return user1;
    }
    /**
     * @param userename 用户名
     * @return com.lzw.entity.User
     * @author 李志文
     * @date 2022/1/28 10:08
     * @description: TODO 验证用户名是否存在
     */
    public static User selectByName(String userename){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectName(userename);
        sqlSession.close();
        return user;
    }
    /**
     * @param user 用户实体类
     * @return void
     * @author 李志文
     * @date 2022/1/28 17:03
     * @description: TODO 更新用户密码
     */
    public static void updateUsername(User user){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(user);
    }
    /**
     * @param user 用户实体类
     * @return void
     * @author 李志文
     * @date 2022/1/28 19:51
     * @description: TODO 注册用户
     */
    public  static void registerUser(User user){
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insertUser(user);
    }

}
