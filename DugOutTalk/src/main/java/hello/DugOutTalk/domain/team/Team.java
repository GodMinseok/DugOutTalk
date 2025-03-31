package hello.DugOutTalk.domain.team;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Team {
    private int id;
    private String name;
    private String logoImg;
    private String mascotImg;

    public Team(int id, String name, String logoImg, String mascotImg) {
        this.id = id;
        this.name = name;
        this.logoImg = logoImg;
        this.mascotImg = mascotImg;
    }

    // 팀 이름을 기준으로 Team 객체를 반환하는 메서드
    public static Team getTeamByName(String teamName) {
        return switch (teamName) {
            case "두산 베어스" -> new Team(1, "두산 베어스", "/images/logos/doosan.png", "/images/mascots/doosan_mascot.png");
            case "LG 트윈스" -> new Team(2, "LG 트윈스", "/images/logos/lg.png", "/images/mascots/lg_mascot.png");
            case "키움 히어로즈" -> new Team(3, "키움 히어로즈", "/images/logos/kiwoom.png", "/images/mascots/kiwoom_mascot.png");
            case "SSG 랜더스" -> new Team(4, "SSG 랜더스", "/images/logos/ssg.png", "/images/mascots/ssg_mascot.png");
            case "NC 다이노스" -> new Team(5, "NC 다이노스", "/images/logos/nc.png", "/images/mascots/nc_mascot.png");
            case "KIA 타이거즈" -> new Team(6, "KIA 타이거즈", "/images/logos/kia.png", "/images/mascots/kia_mascot.png");
            case "삼성 라이온즈" -> new Team(7, "삼성 라이온즈", "/images/logos/samsung.png", "/images/mascots/samsung_mascot.png");
            case "롯데 자이언츠" -> new Team(8, "롯데 자이언츠", "/images/logos/lotte.png", "/images/mascots/lotte_mascot.png");
            case "한화 이글스" -> new Team(9, "한화 이글스", "/images/logos/hanwha.png", "/images/mascots/hanwha_mascot.png");
            case "KT 위즈" -> new Team(10, "KT 위즈", "/images/logos/kt.png", "/images/mascots/kt_mascot.png");
            default -> new Team(0, "알 수 없는 팀", "/images/logos/default.png", "/images/mascots/default_mascot.png");
        };
    }
}
