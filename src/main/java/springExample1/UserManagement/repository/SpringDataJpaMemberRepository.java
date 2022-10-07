package springExample1.UserManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springExample1.UserManagement.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
