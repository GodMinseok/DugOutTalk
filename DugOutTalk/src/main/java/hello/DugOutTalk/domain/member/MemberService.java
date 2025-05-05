package hello.DugOutTalk.domain.member;

import hello.DugOutTalk.domain.DuplicateMemberException;
import hello.DugOutTalk.domain.team.Team;
import hello.DugOutTalk.domain.team.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository; // 팀 정보를 조회하기 위해 추가

    @Transactional
    public Member register(Member member) {
        validateDuplicateMember(member); // 중복 검증
        validatePasswordMatch(member);

        Team team = teamRepository.findByName(member.getFavoriteTeam())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 팀입니다: " + member.getFavoriteTeam()));

        member.setFavoriteTeamLogo(team.getLogoImg()); // 팀 로고 설정

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
}
