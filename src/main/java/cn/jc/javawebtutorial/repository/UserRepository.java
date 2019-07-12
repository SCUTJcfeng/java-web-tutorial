package cn.jc.javawebtutorial.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
// import org.springframework.stereotype.Service;
import cn.jc.javawebtutorial.modal.UserModal;

// @Service
@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addUser(UserModal user) {
        entityManager.createNativeQuery("INSERT INTO test_user (name, age, gender) VALUES (?,?,?)")
                .setParameter(1, user.getName()).setParameter(2, user.getAge())
                .setParameter(3, user.getGender()).executeUpdate();
        System.out.println("success update user");
    }
}
