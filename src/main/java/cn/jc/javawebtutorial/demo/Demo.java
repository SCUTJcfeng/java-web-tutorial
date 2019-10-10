package cn.jc.javawebtutorial.demo;

import org.springframework.stereotype.Service;
import cn.jc.javawebtutorial.annotation.Login;

/**
 * Demo
 */
@Service
public class Demo {

    @Login
    public void name() {
        
    }
}