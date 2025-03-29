package hello.DugOutTalk;

import hello.DugOutTalk.domain.member.Member;
import hello.DugOutTalk.domain.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;

    /**
     * 테스트용 데이터 추가 (중복 체크 후 저장)
     */
    @PostConstruct
    public void init() {
        String testLoginId = "test";

        Optional<Member> existingMember = memberRepository.findByLoginId(testLoginId);

        if (existingMember.isEmpty()) {
            Member member = new Member();
            member.setLoginId(testLoginId);
            member.setPassword("test1234");
            member.setConfirmPassword("test1234");
            member.setEmail("test@test.com");
            member.setFavoriteTeam("롯데 자이언츠");
            member.setNickName("도루왕 이대호");
            member.setName("테스터");

            memberRepository.save(member);
        }
    }
}