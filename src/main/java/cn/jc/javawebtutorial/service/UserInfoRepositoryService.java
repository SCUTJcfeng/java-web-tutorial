package cn.jc.javawebtutorial.service;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import cn.jc.javawebtutorial.modal.UserModal;


public interface UserInfoRepositoryService extends CrudRepository<UserModal, Long> {

    List<UserModal> findByName(String name);

    List<UserModal> findByGender(Boolean gender);
}
