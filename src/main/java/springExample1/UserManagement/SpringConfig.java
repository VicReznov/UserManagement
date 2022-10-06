package springExample1.UserManagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springExample1.UserManagement.repository.MemberRepository;
import springExample1.UserManagement.repository.MemoryMemberRepository;
import springExample1.UserManagement.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
