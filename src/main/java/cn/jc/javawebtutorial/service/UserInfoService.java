package cn.jc.javawebtutorial.service;

import java.util.List;
import cn.jc.javawebtutorial.modal.UserModal;

public interface UserInfoService {
    public String getUserName(UserModal user);

    public Integer getUserAge(UserModal user);

    public Boolean getUserGender(UserModal user);

    public List<UserModal> getUser(String name);

    public UserModal addUser(UserModal user);
}
