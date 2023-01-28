package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수 DI 컨테이너는 싱글톤이 아니다")
    void pureContainer(){
        AppConfig appconfig=new AppConfig();
        //조회 : 호출할 때마다 객체를 생성하게 된다
        MemberService memberService1=appconfig.memberService();
        MemberService memberService2=appconfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        //둘은 다른 객체임을 확일할 수 있다 -> 싱글톤이 아니다
        //요청이 있을때마다 새로운 객체가 생성되는 것은 말이 안되므로 싱글톤(객체를 1개만 생성하여 공유)을 사용하여야 한다.
        Assertions.assertThat(memberService1).isNotEqualTo(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1=SingletonService.getInstance();
        SingletonService singletonService2=SingletonService.getInstance();

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
        //싱글톤 패턴을 적용한 객체는 모두 한 객체를 공유한다.
        //객체 자체가 같은지 비교하려면 isEqualTo가 아닌 isSameAs를 사용한다.
        //스프링 컨테이너에 넣으면 자동으로 싱글톤이 적용된다.

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1=ac.getBean("memberService", MemberService.class);
        MemberService memberService2=ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
        //AppConfig.class에서 싱글톤 디자인이 없었지만, 스프링 컨테이너가 자동으로 싱글톤을 사용해준다.
    }
}
