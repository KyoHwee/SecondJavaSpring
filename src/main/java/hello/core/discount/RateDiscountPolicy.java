package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent=10;  //할인률이 10프로

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){  //VIP고객이면 10프로 할인
            return price*discountPercent/100;
        }else return 0;
    }
}
