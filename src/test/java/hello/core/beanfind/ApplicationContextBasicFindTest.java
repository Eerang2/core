package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.MemberApp;
import hello.core.member.MemberService;
import hello.core.member.MemebrServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemebrServiceImpl.class);
    }
    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean( MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemebrServiceImpl.class);
    }
    @Test
    @DisplayName("구체 타임으로 조회")
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService", MemebrServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemebrServiceImpl.class);
    }
    @Test
    @DisplayName("빈 이름으로 조회가 안됨")
    void findBeanByNameX() {
//        ac.getBean("xxxxx", MemberService.class);   <-- "xxxxx" 라는 이름의 빈 이름이 없기때문에 예외 발생
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxxx", MemberService.class));
    }

}
