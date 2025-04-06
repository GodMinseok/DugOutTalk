package hello.DugOutTalk.controller;

import hello.DugOutTalk.domain.team.Team;
import hello.DugOutTalk.domain.team.TeamRepository;

import hello.DugOutTalk.web.post.Post;
import hello.DugOutTalk.web.post.PostRepository;
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
    public String teamBoard(@PathVariable("id") Long id, Model model) {
        Optional<Team> team = teamRepository.findById(id); // 팀 이름으로 DB 조회

        if (team.isEmpty()) {
            return "redirect:/main"; // 없는 팀이면 메인 페이지로 이동
        }

        List<Post> posts = postRepository.findByTeamOrderByCreatedAtDesc(team.get()); // 해당 팀의 게시글만 조회

        model.addAttribute("team", team.get()); // 팀 정보 전달
        model.addAttribute("posts", posts); // 해당 팀의 게시글 전달
        return "board/board"; // 공통 게시판 페이지로 이동
    }

}

