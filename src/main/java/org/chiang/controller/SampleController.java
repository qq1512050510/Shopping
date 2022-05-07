/**
 * Copyright (c) 2022 765819328@qq.com
 * All rights reserved.
 * Created on 2022-05-05
 */
package org.chiang.controller;

import org.chiang.domain.User;
import org.chiang.result.CodeMsg;
import org.chiang.result.Result;
import org.chiang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : 765819328@qq.com
 * @version :
 * @date : Created in 2022/5/5 11:54
 * @description : 请求接口
 * @modified By :
 */
@Controller
@RequestMapping("/api")
public class SampleController {

    @Autowired
    UserService userService;

    @RequestMapping("/front")
    public String thymeleaf(Model model) {
        model.addAttribute("name", "Chiang");
        return "hello";
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet(Integer id) {
        User user = userService.getById(id);
        return Result.success(user);
    }

    @PostMapping("/db/getTest")
    public Result<String> dbGetTest() {
        return Result.error(CodeMsg.SESSION_ERROR);
    }


    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> dbTx() {
        return Result.success(userService.tx()) ;
    }
}
