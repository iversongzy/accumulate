package org.lgt.dao;

import org.apache.ibatis.annotations.Param;
import org.lgt.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author liuguotai
 * @Date2021/4/9 21:00
 **/
public interface UserDao {
    List<User> getUsers();

    User getUserById(int id);

    List<User> getUserByName(String name);

    List<User> getUserByNameAndPasswd(@Param("name") String name, @Param("pwd") String pwd);

    User getUserByNameAndPasswd2(Map<String,Object> map);

    void addUser(User user);

    void addUser2(Map<String, Object> map);

    void updateUser(User user);

    void deleteUser(int id );
}
