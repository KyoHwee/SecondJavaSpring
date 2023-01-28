package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {  //테스트용 클래스
    public static void main(String[] args) {
        /*
        AppConfig appConfig=new AppConfig();
        MemberService memberService=appConfig.memberService(); //AppConfig에서 필요한 객체 가져온다.
        //이때 memberService는 AppConfig에서 지정한 MemberRepository를 보유하고 있는 상태가 된다.
         */

        //ApplicationContext를를 스프링 컨테너라고 한다.
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        //Appconfig에서 등록해둔 것들 관리해준다.
        MemberService memberService=applicationContext.getBean("memberService", MemberService.class);
        //AppConfig에서 @Bean등록해둔 메소드 명을 key로 두번째 인자로 넣은 class타입으로 객체 받는다

        Member member = new Member(1L, "memberA", Grade.VIP);  //Grade는 enum클래스
        memberService.join(member);
        Member findMember=memberService.findMember(1L);
        System.out.println("new member = "+member.getName());
        System.out.println("find member = "+findMember.getName());
    }
}
