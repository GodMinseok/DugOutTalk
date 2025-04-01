package hello.DugOutTalk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/{teamName}")
    public String teamBoard(@PathVariable String teamName) {
        return "board/" + teamName; // templates/board/{teamName}.html로 이동
    }
}

