package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 di컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        // 호출할때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();
        // 참조값이 다르다
        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService1 = " + memberService1);
        //memberservice1 != memberservice2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

    }
}

