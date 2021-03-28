package org.lgt.java8.stream;


import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author liuguotai
 * @Date2021/1/17 16:52
 **/
public class StreamTest {
    private List<Person> personList = new ArrayList<Person>();

    @Before
    public void init() {
        personList.add(new Person("Sherry", 9000, 24, "female", "New York"));
        personList.add(new Person("Tom", 8900, 22, "male", "Washington"));
        personList.add(new Person("Jack", 9000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 8800, 26, "male", "New York"));
        personList.add(new Person("Alisa", 9000, 26, "female", "New York"));
    }

    @Test
    public void traverseAndMatchCaseTest() {
        TraverseAndMatchOperation operation = new TraverseAndMatchOperation();
        System.out.println(operation.findAnyOperation(personList));
        System.out.println(operation.findFirstOperation(personList));
    }

    @Test
    public void filterCaseTest() {
        FilterOperation operation = new FilterOperation();
        operation.filterOperation(8800, personList);
    }

    @Test
    public void maxCaseTest() {
        MaxAndCountOperation operation = new MaxAndCountOperation();
        System.out.println(operation.getMaxSalary(personList));
    }

    @Test
    public void countCaseTest() {
        MaxAndCountOperation operation = new MaxAndCountOperation();
        System.out.println(operation.getCount(personList));
    }

    @Test
    public void mapOperation() {
        MapOperation operation = new MapOperation();
        operation.mapOperation2(personList);
        operation.mapOperation1(personList);
        operation.flatMapOperation();
    }

    @Test
    public void reduceOperation() {
        ReduceOperation operation = new ReduceOperation();
        System.out.println(operation.getMaxSalary1(personList));
        System.out.println(operation.getMaxSalary2(personList));
        System.out.println(operation.getSumSalary1(personList));
        System.out.println(operation.getSumSalary2(personList));
        System.out.println(operation.getSumSalary3(personList));
    }

    @Test
    public void collectOperation() {
        // 求总数
        Long count = personList.stream().collect(Collectors.counting());
        // 求平均工资
        Double average = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        // 求最高工资
        Optional<Integer> max = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        // 求工资之和
        Integer sum = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        // 一次性统计所有信息
        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));

        Set<Person> set = personList.stream().collect(Collectors.toSet());
        System.out.println(set);

        System.out.println("员工总数：" + count);
        System.out.println("员工平均工资：" + average);
        System.out.println("员工工资总和：" + sum);
        System.out.println("员工工资所有统计：" + collect);

        // 将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        // 将员工按性别分组
        Map<String, List<Person>> group = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        // 将员工先按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> group2 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        System.out.println("员工按薪资是否大于8000分组情况：" + part);
        System.out.println("员工按性别分组情况：" + group);
        System.out.println("员工按性别、地区：" + group2);

        String names = personList.stream().map(p -> p.getName()).collect(Collectors.joining(","));
        System.out.println("所有员工的姓名：" + names);
        List<String> list = Arrays.asList("A", "B", "C");
        String string = list.stream().collect(Collectors.joining("-"));
        System.out.println("拼接后的字符串：" + string);

        // 每个员工减去起征点后的薪资之和（这个例子并不严谨，但一时没想到好的例子）
        Integer sum1 = personList.stream().collect(Collectors.reducing(0, Person::getSalary, (i, j) -> (i + j - 5000)));
        System.out.println("员工扣税薪资总和：" + sum1);

        // stream的reduce
        Optional<Integer> sum2 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("员工薪资总和：" + sum2.get());

    }

    @Test
    public void sortedTest() {
        SortedOperation operation = new SortedOperation();
        operation.getSumSalary1(personList);
    }

    @Test
    public void limitTest() {
        LimitAndReduceAndSkipOperation operation = new LimitAndReduceAndSkipOperation();
        operation.test();
    }

}