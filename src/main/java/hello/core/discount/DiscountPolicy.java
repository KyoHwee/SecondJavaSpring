package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    //할인률이 바뀔 수 있으므로 인터페이스로 할인 금액 반환 메소드 구현
    int discount(Member member, int price);
}
