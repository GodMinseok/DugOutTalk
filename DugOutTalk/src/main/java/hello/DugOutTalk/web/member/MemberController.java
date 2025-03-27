package hello.DugOutTalk.web.member;

import hello.DugOutTalk.domain.DuplicateMemberException;
import hello.DugOutTalk.domain.member.Member;
import hello.DugOutTalk.domain.member.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") Member member) {
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Member member, BindingResult bindingResult) {
        // 기본 유효성 검사
        if (bindingResult.hasErrors()) {
            return "members/addMemberForm";
        }

        try {
            memberService.register(member);
        } catch (DuplicateMemberException e) {
            bindingResult.reject("globalError", e.getMessage()); // 글로벌 에러 추가
            return "members/addMemberForm";
        }

        return "redirect:/";
    }
}
