package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy=new RateDiscountPolicy();
    @Test
    @DisplayName("VIP는 10%할인 적용")  //테스트 돌리면 클래스명이 설정한 한글로 나옴
    void vip_o(){
        //given
        Member member=new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount=discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);//10프로인 1000원 할인 적용되었는지
    }

    @Test
    @DisplayName("VIP가 아니면 할인 적용 안된다")
    void vip_x(){
        //given
        Member member=new Member(1L, "memberBASIC", Grade.BASIC);
        //when
        int discount=discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(0);//basic 회원은 할인이 들어가지 않는지 확인인
   }

}