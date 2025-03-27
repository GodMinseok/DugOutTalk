package hello.DugOutTalk.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByLoginId(String loginId);
    Optional<Member> findByEmail(String email);
    Optional<Member> findByNickName(String nickName);

    // 중복 여부 확인용 메서드 추가
    boolean existsByLoginId(String loginId);
    boolean existsByEmail(String email);
    boolean existsByNickName(String nickName);
}
