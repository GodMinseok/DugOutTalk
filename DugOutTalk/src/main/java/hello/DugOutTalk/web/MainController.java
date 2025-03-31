package hello.DugOutTalk.web;

import hello.DugOutTalk.domain.team.Team;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @GetMapping("/main")
    public String mainPage(Model model) {
        // 팀 이름을 사용하여 Team 객체를 생성
        List<Team> teams = List.of(
                Team.getTeamByName("LG 트윈스"),
                Team.getTeamByName("두산 베어스"),
                Team.getTeamByName("롯데 자이언츠"),
                Team.getTeamByName("삼성 라이온즈"),
                Team.getTeamByName("SSG 랜더스"),
                Team.getTeamByName("한화 이글스"),
                Team.getTeamByName("키움 히어로즈"),
                Team.getTeamByName("KT 위즈"),
                Team.getTeamByName("NC 다이노스"),
                Team.getTeamByName("KIA 타이거즈")
        );
        model.addAttribute("teams", teams);
        return "main"; // main.html 템플릿 파일로 렌더링
    }
}
