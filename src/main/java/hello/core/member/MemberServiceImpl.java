package hello.core.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;//저장소는 메모리로 선택

    public MemberServiceImpl(MemberRepository memberRepository) {  //생성자를 통하여 AppConfig에서
        this.memberRepository = memberRepository;                  //DI될 repository 선택
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
