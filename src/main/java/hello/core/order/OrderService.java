package hello.core.order;

public interface OrderService {  //주문서비스 역할. 클라이언트에 Order받고 회원조회, 할인적용 기능 수행
    Order createOrder(Long memberId, String itemName, int itemPrice);  //최종 Order객체 반환(toString으로)
}
