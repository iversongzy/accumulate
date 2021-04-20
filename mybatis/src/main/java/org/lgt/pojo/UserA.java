package org.lgt.pojo;

import java.util.Objects;

/**
 * @Description
 * @Author liuguotai
 * @Date2021/4/20 20:07
 **/
public class UserA {
    private int id;
    private String name;
    private String passwd;

    public UserA() {
    }

    public UserA(int id, String name, String passwd) {
        this.id = id;
        this.name = name;
        this.passwd = passwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserA userA = (UserA) o;
        return id == userA.id &&
                Objects.equals(name, userA.name) &&
                Objects.equals(passwd, userA.passwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, passwd);
    }

    @Override
    public String toString() {
        return "UserA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
