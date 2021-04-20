package org.lgt.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.lgt.dao.utils.MybatisUtils;
import org.lgt.pojo.User;
import org.lgt.pojo.UserA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void getMapperATest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserADao dao = sqlSession.getMapper(UserADao.class);
        List<UserA> users = dao.getUsers();
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
    public void getUserByNameTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        dao.getUserByName("liu").forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void getUserByNameAndPwdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        dao.getUserByNameAndPasswd("liu", "aaa").forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void getUserByNameAndPwd2Test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name","liu");
        map.put("pwd","aaa");
        System.out.println(dao.getUserByNameAndPasswd2(map));
        sqlSession.close();
    }

    @Test
    public void addUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        dao.addUser(new User(4, "haha", "105922"));
        //增删改都需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2Test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        HashMap<String, Object> hashMap = new HashMap();
        hashMap.put("id", 6);
        hashMap.put("name", "liug");
        hashMap.put("pwd", "eeeeee");
        dao.addUser2(hashMap);
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