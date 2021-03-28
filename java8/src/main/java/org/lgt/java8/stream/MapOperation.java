package org.lgt.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 * @Author liuguotai
 * @Date2021/1/17 19:32
 **/
public class MapOperation {
    //遍历输出符合条件的元素
    public void mapOperation1(List<Person> personList) {
        List<Person> persons = personList.stream().map(person -> {
            person.setSex(person.getSex().toUpperCase());
            return person;
        }).collect(Collectors.toList());
        System.out.println(personList);
        System.out.println(persons);
    }

    public void mapOperation2(List<Person> personList) {
        List<Person> persons =
                personList.stream().map(person -> {
                    String upperCase = person.getSex().toUpperCase();
                    Person newPerson = new Person(person.getName(), person.getSalary(), person.getAge(), upperCase, person.getArea());
                    return newPerson;
                }).collect(Collectors.toList());
        System.out.println(personList);
        System.out.println(persons);
    }

    public void flatMapOperation() {
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> listNew = list.stream().flatMap(s -> {
            // 将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());

        System.out.println("处理前的集合：" + list + list.size());
        System.out.println("处理后的集合：" + listNew + listNew.size());
    }
}
