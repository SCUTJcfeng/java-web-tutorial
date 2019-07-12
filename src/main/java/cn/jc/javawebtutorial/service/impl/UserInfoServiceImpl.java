package cn.jc.javawebtutorial.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.jc.javawebtutorial.modal.UserModal;
import cn.jc.javawebtutorial.service.UserInfoService;
import cn.jc.javawebtutorial.service.UserInfoRepositoryService;

@Service(value = "UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepositoryService userInfoRepositoryService;

    @Override
    public String getUserName(UserModal user) {
        return user.getName();
    }

    @Override
    public Boolean getUserGender(UserModal user) {
        return user.getGender();
    }

    @Override
    public Integer getUserAge(UserModal user) {
        return user.getAge();
    }

    public List<UserModal> getUser(String name) {
        return userInfoRepositoryService.findByName(name);
    }

    public UserModal addUser(UserModal user) {
        return userInfoRepositoryService.save(user);
    }
}


@Service(value = "UserInfoService2")
class UserInfoServiceImpl2 implements UserInfoService {

    @Autowired
    private UserInfoRepositoryService userInfoRepositoryService;

    @Override
    public String getUserName(UserModal user) {
        return user.getName() + "s";
    }

    @Override
    public Boolean getUserGender(UserModal user) {
        return !user.getGender();
    }

    @Override
    public Integer getUserAge(UserModal user) {
        return user.getAge() + 1;
    }

    public List<UserModal> getUser(String name) {
        return userInfoRepositoryService.findByName(name);
    }

    public UserModal addUser(UserModal user) {
        return userInfoRepositoryService.save(user);
    }
}
