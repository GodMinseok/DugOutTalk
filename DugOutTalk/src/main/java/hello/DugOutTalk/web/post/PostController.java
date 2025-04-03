package hello.DugOutTalk.web.post;


import hello.DugOutTalk.domain.team.Team;

import hello.DugOutTalk.domain.team.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String createPost(@RequestParam Long teamId, @RequestParam String title, @RequestParam String content) {
        Optional<Team> team = teamRepository.findById(teamId);

        if (team.isPresent()) {
            Post post = new Post(team.get(), title, content);
            postRepository.save(post);
            return "redirect:/board/" + team.get().getId(); // 팀 ID를 사용

        }
        return "error/404";
    }

}
