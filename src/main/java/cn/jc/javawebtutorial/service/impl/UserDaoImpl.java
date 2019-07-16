package cn.jc.javawebtutorial.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.jc.javawebtutorial.mapper.UserDao;
import cn.jc.javawebtutorial.modal.UserModal;

@Service
public class UserDaoImpl {

    @Autowired
    private UserDao userDao;

    public List<UserModal> selectUserByName(String name) {
        return userDao.findUserByName(name);
    }
}
