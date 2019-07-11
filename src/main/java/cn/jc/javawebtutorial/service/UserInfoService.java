package cn.jc.javawebtutorial.service;

import cn.jc.javawebtutorial.modal.UserModal;

public interface UserInfoService {
    public String getUserName(UserModal user);

    public Integer getUserAge(UserModal user);

    public Boolean getUserGender(UserModal user);
}
