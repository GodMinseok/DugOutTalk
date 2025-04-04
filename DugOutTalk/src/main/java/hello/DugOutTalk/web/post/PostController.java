package hello.DugOutTalk.web.post;

import hello.DugOutTalk.domain.team.Team;
import hello.DugOutTalk.domain.team.TeamRepository;
import hello.DugOutTalk.domain.member.Member;
import hello.DugOutTalk.web.session.SessionConst;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class PostController {

    private final TeamRepository teamRepository;
    private final PostRepository postRepository;

    public PostController(TeamRepository teamRepository, PostRepository postRepository) {
        this.teamRepository = teamRepository;
        this.postRepository = postRepository;
    }

    @PostMapping("/board/post")
    public String createPost(
            @RequestParam("teamId") Long teamId,
            @RequestParam("content") String content,
            HttpSession session,
            RedirectAttributes redirectAttributes
    ) {
        Optional<Team> teamOpt = teamRepository.findById(teamId);
        Member loginMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);

        if (teamOpt.isPresent() && loginMember != null) {
            Team team = teamOpt.get();
            String nickname = loginMember.getNickName();
            String email = loginMember.getEmail();

            Post post = new Post(team, content, nickname, email);
            postRepository.save(post);

            return "redirect:/board/" + team.getId();
        }

        redirectAttributes.addFlashAttribute("errorMessage", "게시글 작성 실패: 로그인 또는 팀 정보 누락");
        return "redirect:/error/404";
    }

}
