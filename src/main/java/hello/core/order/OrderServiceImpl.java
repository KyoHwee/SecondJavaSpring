package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    /*
    private final DiscountPolicy discountPolicy=new FixDiscountPolicy(); //고정할인제
    private final DiscountPolicy discountPolicy=new RateDiscountPolicy(); //퍼센트할인제
    이 두 코드를 바꾸는 순간 OCP, DIP 둘다 어긋난다, 참고로 final이 붙으면 값이 할당되어야 한다 >>AppConfig에서
     */
    private DiscountPolicy discountPolicy; //인터페이스에만 의존하게 하고, 인터페이스는 구현클래스로 DI처리 해준다.

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId); //회원정보 조회
        int discountPrice=discountPolicy.discount(member,itemPrice);  //할인정책으로 할인금액 확인

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
