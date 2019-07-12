package cn.jc.javawebtutorial.service;

import java.util.List;
import cn.jc.javawebtutorial.modal.UserModal;

public interface UserInfoService {
    List<UserModal> getUserByName(String name);

    UserModal getUserById(Long id);

    List<UserModal> getUserByGender(Boolean gender);

    UserModal addUser(UserModal user);
}
