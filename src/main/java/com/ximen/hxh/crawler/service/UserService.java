package com.ximen.hxh.crawler.service;

import com.ximen.hxh.crawler.dao.UserDao;
import com.ximen.hxh.crawler.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hui on 17/7/3.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

}
