package springExample1.UserManagement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springExample1.UserManagement.repository.*;
import springExample1.UserManagement.service.MemberService;

@Configuration
public class SpringConfig {

//    DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


//    private EntityManager em;



    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /*
    Memory -> Jdbc 바꿈
     */
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
