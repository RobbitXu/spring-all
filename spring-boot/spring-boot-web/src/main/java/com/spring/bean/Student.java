package com.spring.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by admin on 2019/4/29.
 */
@Data
public class Student implements Serializable{
    private Integer id;

    private Integer studentId;

    private String name;

    private Integer age;

}
