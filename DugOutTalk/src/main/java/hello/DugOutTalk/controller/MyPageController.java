package hello.DugOutTalk.controller;

import hello.DugOutTalk.domain.login.Login;
import hello.DugOutTalk.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MyPageController {
    @GetMapping("/myPage")
    public String myPage(@Login Member loginMember, Model model) {
        // 로그인된 사용자가 없다면 로그인 페이지로 리디렉션
        if (loginMember == null) {
            return "redirect:/login";
        }

        // 로그인된 사용자의 정보를 마이페이지에 전달
        model.addAttribute("member", loginMember);
        return "myPage";
    }
}
