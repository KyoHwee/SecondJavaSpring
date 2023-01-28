package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean    //Bean등록하면 memberService라는 메소드 명을 key로 하여 return타입인 MemberService객체를 받을수있다
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); //memberRepository 라는 생성자로 Memory 리턴해줌
        //DI할 repository의 구현체로 Memory선택
    }

    @Bean
    public MemberRepository memberRepository() {  //이 생성자를 사용함으로써 AppConfig에 의존관계들을
        return new MemoryMemberRepository();       //다 드러낼 수 있다.
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
        //DI할 repository와 discount정책의 구현체 선택
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();   //고정할인제
        return new RateDiscountPolicy();   //퍼센트 할인제제
   }
}
