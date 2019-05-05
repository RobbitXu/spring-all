package com.spring.lambdaDemo;

import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * lamdba demo
 * Created by admin on 2018/11/6.
 */
public class Demo {

    public static void main(String[] args) {
//        listTest();
//        threadTest();
//        test();
//        test1();
        test2();
    }

    public static void listTest(){
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.forEach(System.out::println);

        list.forEach( i -> {
            System.out.println(i);
        });

    }

    public static void threadTest(){
        new Thread().start();
        new Thread(() -> System.out.println("in ") ).start();
    }


    public static void test(){
        List<String> list = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        filter(list,(str) -> ((String)str).startsWith("J")  );

        filter(list,(str) -> ((String)str).endsWith("a"));

        filter(list,(str) -> true);

        filter(list, (str) -> false);

        filter(list , (str) -> ((String)str).length() > 4);
    }

    public static void filter(List<String> names, Predicate predicate){
        for(String name :names){
            if(predicate.test(name)){
                System.out.println(name +  " ");
            }
        }
    }

    public static void test1(){
        Predicate<String> startWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLength = (n) -> n.length() == 4;

        List<String> list = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        list.stream().filter(startWithJ.and(fourLength)).forEach(System.out::println);
    }

    public static void test2(){
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        list.stream().map((i) -> i * 3).forEach(System.out::println);
        list.forEach(i -> i = i*3);
        list.forEach(System.out::println);

//        Runnable runnable = () -> {
//            System.out.println("aa");
//            System.out.println("bb");
//        };
//
//        new Thread(runnable).start();

        boolean isAdult = doPredicate(20, x -> x >= 18);
        System.out.println(isAdult);

        list.sort(Comparator.naturalOrder());
        list.forEach(System.out::println);

        Integer.valueOf("1");

        Converter<String, Integer> a = (from) -> Integer.valueOf(from);
        Converter<String, Integer> b = Integer :: valueOf;

        Integer m=a.convert("123");
        System.out.println(m);
        Integer n=b.convert("223");
        System.out.println(n);

    }

    public static boolean doPredicate(int age, FunctionalInterfaceTest<Integer> predicate) {
        return predicate.test(age);
    }
}
