package cn.jc.javawebtutorial.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.jc.javawebtutorial.modal.UserModal;
import cn.jc.javawebtutorial.service.UserInfoService;
import cn.jc.javawebtutorial.service.UserInfoRepositoryService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepositoryService userInfoRepositoryService;

    public List<UserModal> getUserByName(String name) {
        return userInfoRepositoryService.findByName(name);
    }

    public List<UserModal> getUserByGender(Boolean gender) {
        return userInfoRepositoryService.findByGender(gender);
    }

    public UserModal getUserById(Long id) {
        Optional<UserModal> modal = userInfoRepositoryService.findById(id);
        try {
            return modal.get();
        } catch (NoSuchElementException e) {
            return new UserModal();
        }
    }

    public UserModal addUser(UserModal user) {
        return userInfoRepositoryService.save(user);
    }
}
