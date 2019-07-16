package cn.jc.javawebtutorial.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import cn.jc.javawebtutorial.modal.UserModal;

public interface UserDao {

    @Select("SELECT * FROM test_user WHERE name = #{name}")
    List<UserModal> findUserByName(@Param("name") String name);
}
