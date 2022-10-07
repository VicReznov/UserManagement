package springExample1.UserManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springExample1.UserManagement.repository.JdbcMemberRepository;
import springExample1.UserManagement.repository.JdbcTemplateMemberRepository;
import springExample1.UserManagement.repository.MemberRepository;
import springExample1.UserManagement.repository.MemoryMemberRepository;
import springExample1.UserManagement.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    /*
    Memory -> Jdbc
     */
    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
