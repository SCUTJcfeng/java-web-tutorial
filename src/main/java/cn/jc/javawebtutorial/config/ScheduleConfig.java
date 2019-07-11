package cn.jc.javawebtutorial.config;

import java.util.Date;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleConfig {

    @Scheduled(cron = "0/30 * * * * ?")
    public void printTime() {
        System.out.println("now is " + new Date().toString());
    }
}
