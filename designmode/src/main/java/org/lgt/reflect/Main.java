package org.lgt.reflect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @Description
 * @Author liuguotai
 * @Date2021/3/13 0:02
 **/
public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println(1314&1);
        new HashMap<>()ap

    }

    public static void aa() {
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
