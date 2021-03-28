package org.lgt.java8.stream;

import java.util.List;
import java.util.Optional;

/**
 * @Description
 * @Author liuguotai
 * @Date2021/1/17 19:51
 **/
public class ReduceOperation {
    public Integer getSumSalary1(List<Person> personList) {
        return personList.stream().map(Person::getSalary).reduce(Integer::sum).get();
    }

    public Integer getSumSalary2(List<Person> personList) {
        return personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(), Integer::sum);
    }

    public Integer getSumSalary3(List<Person> personList) {
        return personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(), (sum1, sum2) -> sum1 + sum2);
    }

    public Integer getMaxSalary1(List<Person> personList) {
        return personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(), Integer::max);
    }

    public Integer getMaxSalary2(List<Person> personList) {
        return personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(), (max1, max2) -> max1 > max2 ? max1 : max2);
    }
}
