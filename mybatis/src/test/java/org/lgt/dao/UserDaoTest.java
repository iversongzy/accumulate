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
}