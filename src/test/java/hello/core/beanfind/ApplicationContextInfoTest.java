package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("등록된 빈 출력")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) { // iter 자동포문완성
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " object = " + bean); // soutv
        }
    }

    @Test
    @DisplayName("등록된 빈 출력")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) { // iter 자동포문완성
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);


            // Role ROLE_APPLICATION : 직접 등록한 애플리케이션
            // Role ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈빈
           if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                // 내가 등록한 bean인경우
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " object = " + bean); // soutv
            }
        }
    }



}
