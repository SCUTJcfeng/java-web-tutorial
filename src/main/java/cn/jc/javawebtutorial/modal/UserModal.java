package cn.jc.javawebtutorial.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "test_user")
@Data
public class UserModal {

    public UserModal() {
    }

    public UserModal(String name, Integer age, Boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

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
}
