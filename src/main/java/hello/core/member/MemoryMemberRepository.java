package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{  //DB를 사용하지 않는 메모리 사용 repository
    private static Map<Long, Member> store=new HashMap<>();  //저장소

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
