package com.shf.service.impl;

import com.shf.pojo.User;
import com.shf.service.UserService;
import org.apache.dubbo.config.annotation.Service;


//@Service  将该类的对象创建处理,放到spring的IOC容器中
// 将这个类提供的方法 服务对外发布。将访问的地址ip端口，路径注册到注册中心中
//当前服务3秒超时，重试3次
@Service(version = "v1.0",timeout = 3000,retries = 2,weight = 100)
public class UserServiceImpl implements UserService {
    @Override
    public String sayHello(){
        return "111111111111-hello dubbo！！！！";
    }

    @Override
    public User findUserById(int id) {
        System.out.println("old");
        User user = new User(1, "zhangsan", "123");
        return user;
    }
}
