package com.spring.service;

import com.spring.bean.User;

import java.util.List;

/**
 * Created by admin on 2019/4/30.
 */
public interface UserService {
    public boolean insert(User u);

    public List<User> findAll();

    public List<User> findByUserIds(List<Integer> ids);

    public void transactionTestSucess();

    public void transactionTestFailure() throws IllegalAccessException;
}
