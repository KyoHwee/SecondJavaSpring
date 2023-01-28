package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.lang.model.SourceVersion;
import java.lang.annotation.Annotation;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames=ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean=ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName+" object= "+bean);
        }
    }

    @Test
    @DisplayName("내가 등록한 빈만(애플리케이션 빈만) 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames=ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition=ac.getBeanDefinition(beanDefinitionName);
            //BeanDefinition : Bean들의 역할을 가져올 수 있다.
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                //BeanDefinition.ROLE_APPLICATION : 내가 등록한 빈(애플리케이션 빈)
                Object bean=ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName+" object= "+bean);
            }
        }
    }


}
