package cn.jc.javawebtutorial.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import lombok.Data;

@Entity
@Table(name = "test_user")
@Data
public class UserModal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column()
    private String name;

    @NotNull
    @Column()
    private Integer age;

    @NotNull
    @Column()
    private Boolean gender;

    @Modifying
    @Query("INSERT INTO `test_user` ")
    public Boolean addUser(UserModal user) {
        return true;
    }
}
