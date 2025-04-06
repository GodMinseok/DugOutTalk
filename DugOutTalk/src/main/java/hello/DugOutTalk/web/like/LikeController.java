package hello.DugOutTalk.web.like;

import hello.DugOutTalk.domain.login.Login;
import org.springframework.stereotype.Controller;

import hello.DugOutTalk.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/board/like/{postId}")
    public String likePost(@PathVariable("postId") Long postId,
                           @RequestParam("teamId") Long teamId,
                           @Login Member user) {
        likeService.likePost(postId, user);
        return "redirect:/team/" + teamId + "/board";
    }

}

