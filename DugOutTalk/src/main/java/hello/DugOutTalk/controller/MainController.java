package hello.DugOutTalk.controller;

import hello.DugOutTalk.domain.team.Team;
import hello.DugOutTalk.domain.team.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final TeamService teamService;

    @GetMapping("/main")
    public String mainPage(Model model) {
        List<Team> teams = teamService.getAllTeams();
        model.addAttribute("teams", teams);
        return "main";
    }
}


