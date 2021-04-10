package org.lgt.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.lgt.dao.utils.MybatisUtils;
import org.lgt.pojo.User;

import java.util.List;

/**
 * @Description
 * @Author liuguotai
 * @Date2021/4/9 21:14
 **/
public class UserDaoTest {

    @Test
    public void getMapperTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        List<User> users = dao.getUsers();
        users.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void getUserByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        System.out.println(dao.getUserById(1));
        sqlSession.close();
    }

    @Test
    public void addUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        dao.addUser(new User(4, "haha", "105922"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        dao.updateUser(new User(4, "haha", "ddd"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        dao.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }
}