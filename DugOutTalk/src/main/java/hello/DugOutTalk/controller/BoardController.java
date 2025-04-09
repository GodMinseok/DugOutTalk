package hello.DugOutTalk.controller;

import hello.DugOutTalk.domain.member.Member;
import hello.DugOutTalk.domain.team.Team;
import hello.DugOutTalk.domain.team.TeamRepository;

import hello.DugOutTalk.web.post.Post;
import hello.DugOutTalk.web.post.PostRepository;
import hello.DugOutTalk.web.session.SessionConst;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final TeamRepository teamRepository;
    private final PostRepository postRepository;

    public BoardController(TeamRepository teamRepository, PostRepository postRepository) {
        this.teamRepository = teamRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/{id}")
    public String teamBoard(@PathVariable("id") Long id, Model model, HttpSession session) {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isEmpty()) {
            return "redirect:/main";
        }

        List<Post> posts = postRepository.findByTeamOrderByCreatedAtDesc(team.get());
        Member loginMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER); // 로그인 사용자 정보

        model.addAttribute("team", team.get());
        model.addAttribute("posts", posts);
        model.addAttribute("loginMember", loginMember); // 추가

        return "board/board";
    }


}

