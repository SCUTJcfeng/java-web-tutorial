package cn.jc.javawebtutorial.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import cn.jc.javawebtutorial.modal.UserModal;

@Mapper
public interface UserDao {

    @Select("SELECT * FROM test_user WHERE name = #{name}")
    UserModal findUserByName(@Param("name") String name);
}
