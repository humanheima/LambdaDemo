package com.hm.lambda.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by dumingwei on 2017/3/13.
 */
public class StreamTest {
    private static List<Person> javaProgrammers = new ArrayList<>();
    private static List<Person> androidProgrammers = new ArrayList<>();

    public static void main(String[] args) {
        javaProgrammers = Person.getJavaProgrammers();
        androidProgrammers = Person.getAndroidProgrammers();
        /**
         * forEach
         */
      /*  System.out.println("所有程序员的姓名");
        javaProgrammers.forEach(p -> System.out.printf("%s %s\n", p.getFirstName(), p.getLastName()));
        androidProgrammers.forEach(p -> System.out.printf("%s %s\n", p.getFirstName(), p.getLastName()));
        System.out.println("所有程序员工资增加5%");
        Consumer<Person> giveRaise = person -> person.setSalary(person.getSalary() / 100 * 5 + person.getSalary());
        javaProgrammers.forEach(giveRaise);
        androidProgrammers.forEach(giveRaise);
        javaProgrammers.forEach(p -> System.out.printf("%d\n", p.getSalary()));
        androidProgrammers.forEach(p -> System.out.printf("%d\n", p.getSalary()));*/
        /**
         * filter
         */
        //定义过滤条件
       /* Predicate<Person> salaryFilter = p -> p.getSalary() > 1400;
        Predicate<Person> ageFilter = p -> p.getAge() > 25;
        Predicate<Person> genderFilter = p -> "female".equals(p.getGender());

        androidProgrammers.stream()
                .filter(salaryFilter)
                .filter(genderFilter)
                .forEachOrdered(p -> System.out.println(p.getSalary()));

        androidProgrammers.stream()
                .filter(salaryFilter)
                .filter(ageFilter)
                .forEachOrdered(p -> System.out.println(p.getSalary()));*/
        /**
         * limit
         * filter 和limit的调用顺序不一样，结果也不一样
         */
      /*  System.out.println("只输出三个programmers");
        javaProgrammers.stream()
                .filter(person -> "female".equals(person.getGender()))
                .limit(3)
                .forEach(p -> System.out.println(p.getFirstName()));*/

        /**
         * sorted collect max min
         */
        /*Comparator<Person> cmp = Comparator.comparing(Person::getLastName, String::compareTo);
        System.out.println("根据 name 排序,并显示前5个 Java programmers:");
        List<Person> sortedJavaProgrammers = javaProgrammers.stream()
                .sorted(cmp)
                .limit(5)
                .collect(Collectors.toList());
        sortedJavaProgrammers.forEach(person -> System.out.println(person.getLastName()));

        System.out.println("根据 salary 排序 Java programmers:");

        sortedJavaProgrammers = javaProgrammers.stream()
                .sorted((p1, p2) -> (p1.getSalary() - p2.getSalary()))
                .collect(Collectors.toList());
        sortedJavaProgrammers.forEach(person -> System.out.println(person.getSalary()));

        System.out.println("工资最低的 Java programmer:");
        Person minPerson = javaProgrammers.stream()
                .min((p1, p2) -> (p1.getSalary() - p2.getSalary()))
                .get();
        System.out.println(minPerson.getSalary());
        System.out.println("工资最高的 Java programmer:");
        Person maxPerson = javaProgrammers.stream()
                .max((p1, p2) -> (p1.getSalary() - p2.getSalary()))
                .get();
        System.out.println(maxPerson.getSalary());*/
        /**
         * map
         */
       /* System.out.println("将 android programmers 的 first name 拼接成字符串:");
        String androidDevelopers = androidProgrammers
                .stream()
                .map(Person::getFirstName)
                .collect(Collectors.joining(","));
        System.out.println(androidDevelopers);
        System.out.println("将 Java programmers 的 first name 存放到 Set:");
        Set<String> stringSet = androidProgrammers.stream()
                .map(Person::getFirstName)
                .collect(Collectors.toSet());
        stringSet.forEach(System.out::println);*/

        /**
         * parallel stream
         */
       /* System.out.println("计算付给 Java programmers 的所有money:");
        int totalMoney = javaProgrammers
                .parallelStream()
                .mapToInt(Person::getSalary)
                .sum();
        System.out.println(totalMoney);

       List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        IntSummaryStatistics summaryStatistics = numbers
                .stream()
                .collect(IntSummaryStatistics::new, IntSummaryStatistics::accept, IntSummaryStatistics::combine);
        IntSummaryStatistics summary = numbers
                .stream()
                .mapToInt(x->x)
                .summaryStatistics();
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getCount());*/

        /**
         * groupingBy
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Integer, List<Integer>> map = numbers.stream()
                .collect(Collectors.groupingBy((x) -> x % 3));
        System.out.println(map);

        Collection<Task> tasks = Arrays.asList(
                new Task(Task.Status.OPEN, 5),
                new Task(Task.Status.OPEN, 13),
                new Task(Task.Status.CLOSED, 8)
        );
        //计算每个task占得比重
        final int totalPoints = tasks.stream()
                .mapToInt(Task::getPoints)
                .sum();
        System.out.println(totalPoints);
        Collection<String> result = tasks
                .stream()
                .mapToInt(Task::getPoints)
                .mapToDouble(points -> points * 100 / totalPoints)
                .mapToInt(weight->(int)weight)
                .mapToObj(percentage -> percentage + "%")
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
