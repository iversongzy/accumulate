package org.lgt.dao;

import org.lgt.pojo.UserA;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author liuguotai
 * @Date2021/4/9 21:00
 **/
public interface UserADao {
    List<UserA> getUsers();

    UserA getUserById(int id);

    List<UserA> getUserByName(String name);

    void addUser(UserA user);

    void addUser2(Map<String, Object> map);

    void updateUser(UserA user);

    void deleteUser(int id );
}
