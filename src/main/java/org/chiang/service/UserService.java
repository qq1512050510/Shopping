/**
 * Copyright (c) 2022 765819328@qq.com
 * All rights reserved.
 * Created on 2022-05-07
 */
package org.chiang.service;

import org.chiang.dao.UserDao;
import org.chiang.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : 765819328@qq.com
 * @version :
 * @date : Created in 2022/5/7 16:40
 * @description : 用户服务
 * @modified By :
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getById(Integer id) {
        return userDao.getById(id);
    }

//    @Transactional
    public boolean tx() {
        User u1 = new User();
        u1.setId(3);
        u1.setName("test3");
        userDao.insert(u1);
        User u2 = new User();
        u2.setId(3);
        u2.setName("test3");
        userDao.insert(u2);


        return true;
    }
}
