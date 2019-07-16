package cn.jc.javawebtutorial.mapper;

import cn.jc.javawebtutorial.modal.UserInfo;
import java.util.List;

public interface UserInfoMapper {
    int insert(UserInfo record);

    List<UserInfo> selectAll();
}