package com.shf.controller;

import com.shf.pojo.User;
import com.shf.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
//    注入service
//    @Autowired  本地注入

    /**
     * 1.从zookeeper注册中心获取user Service的访问url
     * 2. 进行远程调用RPC
     * 3.将结果封装为一个代理对象
     */
    @Reference(version = "v2.0") // 远程注入
    private UserService userService;

    @RequestMapping("/sayHello")
    public String sayHello() {
        return userService.sayHello();
    }

    /**
     * 根基id
     *
     * @return
     */
    @RequestMapping("/find")
    public User find(int id) throws InterruptedException {
        return userService.findUserById(id);
    }
}
