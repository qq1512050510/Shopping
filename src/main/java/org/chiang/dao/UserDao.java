/**
 * Copyright (c) 2022 765819328@qq.com
 * All rights reserved.
 * Created on 2022-05-07
 */
package org.chiang.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.chiang.domain.User;

/**
 * @author : 765819328@qq.com
 * @version :
 * @date : Created in 2022/5/7 16:35
 * @description : 用户DAO
 * @modified By :
 */
@Mapper
public interface UserDao {

    @Select("select * from user where id = #{id}")
    User getById(@Param("id") Integer id);

    @Insert("insert into user(id,name) values(#{id},#{name})")
    int insert(User user);
}
