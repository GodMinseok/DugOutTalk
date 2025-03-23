package hello.DugOutTalk;



import hello.DugOutTalk.domain.member.Member;
import hello.DugOutTalk.domain.member.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TestDataInit {


    private final MemberRepository memberRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {

        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("test!");
        member.setEmail("test@test.com");
        member.setFavoriteTeam("롯데 자이언츠");
        member.setNickName("도루왕 이대호");
        member.setName("테스터");

        memberRepository.save(member);
    }

}