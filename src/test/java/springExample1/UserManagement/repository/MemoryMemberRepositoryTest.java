package springExample1.UserManagement.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import springExample1.UserManagement.domain.Member;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트 케이스마다 에러나지 않게 메소드가 테스트를 끝내면 비워줌
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("firstman");

        repository.save(member);

        Member result1 = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result1);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);

        Member result = repository.findByName("member1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
