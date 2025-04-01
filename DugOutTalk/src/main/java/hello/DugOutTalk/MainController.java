package hello.DugOutTalk;

import hello.DugOutTalk.domain.team.Team;
import hello.DugOutTalk.domain.team.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final TeamService teamService;

    @GetMapping("/main")
    public String mainPage(Model model) {
        List<Team> teams = teamService.getAllTeams();
        model.addAttribute("teams", teams);
        return "main"; // main.html 렌더링
    }
}


