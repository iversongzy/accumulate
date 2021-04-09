package org.lgt.dao;

import org.lgt.pojo.User;

import java.util.List;

/**
 * @Description
 * @Author liuguotai
 * @Date2021/4/9 21:00
 **/
public interface UserDao {
    List<User> getUsers();
}
