package cn.jc.javawebtutorial.service.impl;

import org.springframework.stereotype.Service;
import cn.jc.javawebtutorial.modal.UserModal;
import cn.jc.javawebtutorial.service.UserInfoService;

@Service(value = "UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {

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
}


@Service(value = "UserInfoService2")
class UserInfoServiceImpl2 implements UserInfoService {

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
}
