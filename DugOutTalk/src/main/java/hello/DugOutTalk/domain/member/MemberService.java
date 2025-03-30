package hello.DugOutTalk.domain.member;

import hello.DugOutTalk.domain.DuplicateMemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member register(Member member) {
        validateDuplicateMember(member); // 중복 검증
        member.setFavoriteTeamLogo(getTeamLogoUrl(member.getFavoriteTeam())); // 팀 로고 설정
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        if (memberRepository.existsByLoginId(member.getLoginId())) {
            throw new DuplicateMemberException("이미 존재하는 아이디입니다.");
        }
        if (memberRepository.existsByEmail(member.getEmail())) {
            throw new DuplicateMemberException("이미 사용 중인 이메일입니다.");
        }
        if (memberRepository.existsByNickName(member.getNickName())) {
            throw new DuplicateMemberException("이미 사용 중인 닉네임입니다.");
        }
    }

    private void validatePasswordMatch(Member member) {
        if (!member.getPassword().equals(member.getConfirmPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

    private String getTeamLogoUrl(String teamName) {
        return switch (teamName) {
            case "두산 베어스" -> "/images/logos/doosan.png";
                case "LG 트윈스" -> "/images/logos/lg.png";
            case "키움 히어로즈" -> "/images/logos/kiwoom.png";
            case "SSG 랜더스" -> "/images/logos/ssg.png";
            case "NC 다이노스" -> "/images/logos/nc.png";
            case "KIA 타이거즈" -> "/images/logos/kia.png";
            case "삼성 라이온즈" -> "/images/logos/samsung.png";
            case "롯데 자이언츠" -> "/images/logos/lotte.png";
            case "한화 이글스" -> "/images/logos/hanwha.png";
            case "KT 위즈" -> "/images/logos/kt.png";
            default -> "/images/logos/default.png";
        };
    }
}
