package org.lgt.java8.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author liuguotai
 * @Date2021/1/17 16:57
 **/
public class FilterOperation {

    //遍历输出符合条件的元素
    public void filterOperation(int salary, List<Person> personList) {
        List<String> list =
                personList.stream().filter(person -> person.getSalary() > salary).map(Person::getName).collect(Collectors.toList());
        System.out.println(list);
    }

}
