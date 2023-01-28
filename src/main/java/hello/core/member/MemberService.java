package hello.core.member;

public interface MemberService {  //클라이언트와 연결되는 회원가입, 회원조회 서비스
    void join(Member member);

    Member findMember(Long memberId);
}
