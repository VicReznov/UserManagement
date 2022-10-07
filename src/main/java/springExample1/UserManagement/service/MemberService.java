package springExample1.UserManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springExample1.UserManagement.domain.Member;
import springExample1.UserManagement.repository.MemberRepository;
import springExample1.UserManagement.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

@Transactional // JPA 사용하려면 필요함 -> 특히 join()에서
public class MemberService {

    private final MemberRepository memberRepository;

    // MemberService DI
    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    // 회원가입 메소드
    public Long join(Member member){
        // 이름이 중복인 회원은 가입 불가
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

        memberRepository.save(member);
        return member.getId();
    }

    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 회원 한 명 찾기
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
