package org.lgt.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Description 遍历/匹配操作
 * @Author liuguotai
 * @Date2021/1/17 16:27
 **/
public class TraverseAndMatchOperation {

    //匹配第一个
    public Person findFirstOperation(List<Person> personList) {
        Optional<Person> personOptional = personList.stream().filter(person -> person.getSalary() > 8000).findFirst();
        return  personOptional.get();
    }

    //匹配任意一个
    public Person findAnyOperation(List<Person> personList) {
        return personList.parallelStream().filter(person -> person.getSalary() > 8000).findAny().get();
    }

    //是否包含符合条件的元素
    public boolean anyMatchOperation(int salary, List<Person> personList) {
        return personList.stream().anyMatch(person -> person.getSalary() > salary);
    }

}
