package com.test.demo.test;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/3/25 10:02
 */
public class J8Stream {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("d");
        list.add("e");

        list.forEach(s -> {
            System.out.print(s);
        });
        System.out.println();
        buildStream(list);

        List<String> mapList = new ArrayList<>();
        mapList.add("a a");
        mapList.add("b b");
        mapList.add("c c");
        mapList.add("d d");

        List<User> userList = new ArrayList<>();
        userList.add(new User(12,"cpd",true));
        userList.add(new User(14,"wyw",false));
        userList.add(new User(11,"cxm",false));

        System.out.println(userList.stream().map(User::isStudents).collect(Collectors.toList()).contains("t"));

        streamMap(mapList,userList);
//
//        streamSort(list,userList);
//
//        streamMatch(userList);
//
//        streamStatute(userList);
//
//        streamCollect(userList);
    }

    /**
     * filter(Predicatep):接收Lambda,从流中排除某些元素
     * limit(long maxsize):截断流，使其元素不超过给定数量
     * skip(long n):跳过元素，返回一个扔掉了前n个元素的流
     * distinct():筛选，通过流所生成元素的hashcode()和equals()去除重复的元素
     * @param list
     * @return
     */
    public static void buildStream(List<String> list){
        list.stream().filter((e)->{
            return !e.equals("c");
        }).forEach(System.out::printf);

        //limit(long maxsize):截断流，使其元素不超过给定数量
        System.out.println();
        list.stream().limit(2).forEach(e -> {
            System.out.printf(e);
        });

        //skip(long n):跳过元素，返回一个扔掉了前n个元素的流
        System.out.println();
        list.stream().skip(3).forEach(s -> {
            System.out.print(s);
        });

        //distinct():筛选，通过流所生成元素的hashcode()和equals()去除重复的元素
        System.out.println();
        list.stream().distinct().forEach(s -> {
            System.out.print(s);
        });
    }

    /**
     * map(Function f):接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap(Function f):接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成一个流
     * @param list
     */
    public static void streamMap(List<String> list,List<User> userList){
        System.out.println();
        System.out.println("-------------map测试-----------");
        userList.stream().map(User::getName
        ).forEach(name -> System.out.print(name));

        System.out.println();

        list.stream().flatMap(s -> Arrays.stream(s.split(" "))).forEach(s-> System.out.print(s));
    }

    /**
     * 排序
     * sorted():产生一个新的流，其中按自然排序
     * sorted(Comparatorcomp):产生一个新流，其中按比较器顺序排序
     * @param list
     */
    public static void streamSort(List<String> list,List<User> userList){
        System.out.println();
        System.out.println("--------排序测试-----------");
        list.stream().sorted().forEach(s-> System.out.print(s));

        System.out.println();
        userList.stream().sorted(Comparator.comparing(User::getAge)).forEach(System.out::print);
    }

    /**
     * 查找与匹配
     * allMatch(Predicate p):检查是否匹配所有的元素
     * anyMatch(Predicate p):检查是否至少匹配一个元素
     * noneMatch(Predicate p):检查是否没有匹配所有的元素
     * findFirst();返回第一个元素
     * findAny():返回当前流中的任意元素
     * count():返回流中元素总数
     * max(Comparator c):返回流中最大值
     * min(Comparator c):返回流中最小值
     * forEach(Consumer c):内部迭代（使用Collection接口需要用户去迭代，称为外部迭代，相反，Stream API使用内部迭代）
     */
    public static void streamMatch(List<User> userList){
        System.out.println();
        System.out.println("------------查找与匹配-------------");
        boolean b = userList.stream().allMatch(s -> "cpd".equals(s.getName()));
        System.out.println(b);

        boolean c = userList.stream().anyMatch(s -> "cpd".equals(s.getName()));
        System.out.println(c);

        boolean d = userList.stream().noneMatch(s -> "cpd".equals(s.getName()));
        System.out.println(d);

        Optional<User> first = userList.stream().findFirst();
        System.out.println(first.get());

        Optional<User> any = userList.stream().findAny();
        System.out.println(any.get());

        long count = userList.stream().count();
        System.out.println(count);

        Optional<User> max = userList.stream().max(Comparator.comparingInt(User::getAge));
        System.out.println(max.get());

        Optional<User> min = userList.stream().min(Comparator.comparingInt(User::getAge));
        System.out.println(min.get());
    }

    /**
     * 规约
     * reduce(T iden,BinaryOperator b):可以将流中的元素反复结合起来，得到一个值，返回T
     * reduce(BinaryOperator b):可以将流中的元素反复结合起来，得到一个值，返回option<T>
     */
    public static void streamStatute(List<User> userList){
        System.out.println("------------规约-------------");

        Integer reduce = userList.stream().map(User::getAge).reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        Optional<Integer> reduce1 = userList.stream().map(User::getAge).reduce(Integer::sum);
        System.out.println(reduce1.get());
    }

    /**
     * 收集
     * collect(Collector c):将流转换为其他形式。接收一个Collector接口的实现，用于stream中元素做汇总的方法
     * @param userList
     */
    public static void streamCollect(List<User> userList){
        System.out.println("-------------收集---------------");

        List<User> collect = userList.stream().collect(Collectors.toList());
        collect.forEach(System.out::print);

        System.out.println();
        Set<User> collect1 = userList.stream().collect(Collectors.toSet());
        collect1.forEach(System.out::print);

        System.out.println();
        Long collect2 = userList.stream().collect(Collectors.counting());
        System.out.println("个数："+collect2);

        Double collect3 = userList.stream().collect(Collectors.averagingDouble(User::getAge));
        System.out.println("平均值："+collect3);

        Double collect4 = userList.stream().collect(Collectors.summingDouble(User::getAge));
        System.out.println("总和："+collect4);

        Optional<User> collect5 = userList.stream().collect(Collectors.maxBy(Comparator.comparing(User::getAge)));
        System.out.println("最大值："+collect5.get());

        Optional<User> collect6 = userList.stream().collect(Collectors.minBy(Comparator.comparing(User::getAge)));
        System.out.println("最小值："+collect6.get());

        Map<String, List<User>> collect7 = userList.stream().collect(Collectors.groupingBy(User::getName));
        System.out.println("分组："+collect7);

        Map<String, Map<Integer, List<User>>> collect8 = userList.stream().collect(Collectors.groupingBy(User::getName, Collectors.groupingBy(User::getAge)));
        System.out.println("多级分组："+collect8);

        Map<Boolean, List<User>> collect9 = userList.stream().collect(Collectors.partitioningBy(e -> e.getName().equals("cpd")));
        System.out.println("分区："+collect9);

        DoubleSummaryStatistics collect10 = userList.stream().collect(Collectors.summarizingDouble(User::getAge));
        System.out.println("统计值最大值："+collect10.getMax());
        System.out.println("统计值最小值："+collect10.getMin());
        System.out.println("统计值平均值："+collect10.getAverage());
        System.out.println("统计值总和："+collect10.getCount());

        String collect11 = userList.stream().map(User::getName).collect(Collectors.joining());
        System.out.println("连接字符串："+collect11);

        String collect12 = userList.stream().map(User::getName).collect(Collectors.joining(","));
        System.out.println("连接字符串按逗号拼接："+collect12);

        Integer collect13 = userList.stream().collect(Collectors.reducing(0, User::getAge, Integer::sum));
        System.out.println("累加："+collect13);

        Integer collect14 = userList.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
        System.out.println(collect14);
    }


}


class User{
    Integer age;
    String name;
    boolean isStudents;

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public User(Integer age, String name, boolean isStudents) {
        this.age = age;
        this.name = name;
        this.isStudents = isStudents;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStudents() {
        return isStudents;
    }

    public void setStudents(boolean students) {
        isStudents = students;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
