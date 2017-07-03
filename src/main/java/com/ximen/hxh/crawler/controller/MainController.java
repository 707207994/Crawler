package com.ximen.hxh.crawler.controller;

import com.ximen.hxh.crawler.model.User;
import com.ximen.hxh.crawler.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;


@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    private UserService userService;

    //测试函数，测试spring-MVC框架
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String welcome() {
        return "hello world main controller";
    }

    //测试函数，测试mybatis是否配置成功
    @RequestMapping("/testBatis")
    @ResponseBody
    public String index() throws IOException {
        String resource = "conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        String string;
        string = session.selectOne("userMapper.findUserById", 101);//测试mybatis
        return string;
    }

    @ResponseBody
    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable(value = "id") int id) {
        return userService.findUserById(id);
    }


}