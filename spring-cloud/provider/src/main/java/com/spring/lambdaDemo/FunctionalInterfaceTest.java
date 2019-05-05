package com.spring.lambdaDemo;

/**
 * Created by admin on 2018/11/7.
 */
@FunctionalInterface
public interface FunctionalInterfaceTest<T> {
    boolean test(T t);

    default Integer test1(){
        return 1;
    }
}

