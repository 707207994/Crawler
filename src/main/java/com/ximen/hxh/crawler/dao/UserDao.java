package com.ximen.hxh.crawler.dao;

import com.ximen.hxh.crawler.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by hui on 17/7/3.
 */
@Repository
public class UserDao extends BaseDao{

    private static final String MAPPER_NAMESPACE = "userMapper.";

    public User findUserById(int id) {
        return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + "findUserById", id);
    }

}
