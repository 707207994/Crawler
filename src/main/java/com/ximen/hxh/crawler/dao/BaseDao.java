package com.ximen.hxh.crawler.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hui on 17/7/3.
 */
public class BaseDao {
    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;
}
