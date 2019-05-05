package com.spring.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by admin on 2019/4/29.
 */
@Data
public class User implements Serializable{

    private Integer id;

    private Integer userId;

    private String name;

    private Integer age;

}
