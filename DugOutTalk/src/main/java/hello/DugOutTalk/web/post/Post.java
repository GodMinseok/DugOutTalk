package hello.DugOutTalk.web.post;

import hello.DugOutTalk.domain.team.Team;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team; // 어떤 팀 게시판의 글인지 저장

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    public Post(Team team, String title, String content) {
        if (team == null) {
            throw new IllegalArgumentException("팀 정보가 없습니다!");
        }
        this.team = team;
        this.title = title;
        this.content = content;
    }

}
