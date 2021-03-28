package org.lgt.java8.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @Description
 * @Author liuguotai
 * @Date2021/1/17 19:06
 **/
public class MaxAndCountOperation {
    //匹配任意一个
    public Person getMaxSalary(List<Person> personList) {
        Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        return max.get();
    }

    public long getCount(List<Person> personList) {
        return personList.stream().filter(person -> person.getSalary() > 8500).count();
    }
}
