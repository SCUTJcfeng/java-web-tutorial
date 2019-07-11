package cn.jc.javawebtutorial.service.impl;

import org.springframework.stereotype.Service;
import cn.jc.javawebtutorial.modal.UserModal;
import cn.jc.javawebtutorial.service.UserInfoService;

@Service
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
