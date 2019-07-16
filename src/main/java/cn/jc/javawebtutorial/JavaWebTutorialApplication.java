package cn.jc.javawebtutorial;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.jc.javawebtutorial.mapper")
@SpringBootApplication
public class JavaWebTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaWebTutorialApplication.class, args);
    }
}
