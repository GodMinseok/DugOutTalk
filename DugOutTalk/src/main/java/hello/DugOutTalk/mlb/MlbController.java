package hello.DugOutTalk.mlb;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Map;

@Controller
public class MlbController {

    @GetMapping("/mlb/mlbSchedule")
    public String getMlbSchedule(@RequestParam(value = "date", required = false) String date, Model model) {
        // 기본 날짜: 오늘
        if (date == null || date.isEmpty()) {
            date = LocalDate.now().toString(); // yyyy-MM-dd 형식
        }

        String url = "https://statsapi.mlb.com/api/v1/schedule?sportId=1&date=" + date;
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
            model.addAttribute("scheduleData", response.getBody());
        } catch (Exception e) {
            model.addAttribute("scheduleData", null);
        }

        model.addAttribute("selectedDate", date);
        return "mlb/mlbSchedule"; // templates/mlb/mlbSchedule.html
    }

    @GetMapping("/mlb/mlbScore")
    public String getMlbStandings(@RequestParam(value = "leagueId", required = false) String leagueId, Model model) {
        if (leagueId == null || leagueId.isEmpty()) {
            leagueId = "103,104"; // 기본값: 둘 다
        }

        String url = "https://statsapi.mlb.com/api/v1/standings?leagueId=" + leagueId + "&season=2025&standingsTypes=regularSeason";
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
            model.addAttribute("standingsData", response.getBody());
        } catch (Exception e) {
            model.addAttribute("standingsData", null);
        }

        model.addAttribute("selectedLeagueId", leagueId);
        return "mlb/mlbScore";
    }


    @GetMapping("/mlb/mlbResult")
    public String getMlbResults(@RequestParam(value = "date", required = false) String date, Model model) {
        if (date == null || date.isEmpty()) {
            date = LocalDate.now().toString();
        }

        String url = "https://statsapi.mlb.com/api/v1/schedule?sportId=1&date=" + date + "&hydrate=team,linescore";
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
            model.addAttribute("resultData", response.getBody());
        } catch (Exception e) {
            model.addAttribute("resultData", null);
        }

        model.addAttribute("selectedDate", date);
        return "mlb/mlbResult";
    }




}

