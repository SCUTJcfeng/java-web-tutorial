package cn.jc.javawebtutorial.config;

import java.lang.reflect.Method;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import cn.jc.javawebtutorial.annotation.Login;
import lombok.extern.slf4j.Slf4j;

/**
 * GatewayConfig
 */
@Slf4j
@Component
public class GatewayConfig implements InitializingBean, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void afterPropertiesSet() throws Exception {
      log.info("【GatewayConfig】 afterPropertiesSet");
      String[] beanNames = context.getBeanDefinitionNames();
      for (String beanName : beanNames) {
          Class<?> type = context.getType(beanName);
          for (Method m : type.getDeclaredMethods()) {
              Login login = AnnotationUtils.findAnnotation(m, Login.class);
              if (login != null) {
                  log.info("【GatewayConfig】Find Login: " + login.value());
              }
          }
      }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("【GatewayConfig】 setApplicationContext");
        context = applicationContext;
    }
}