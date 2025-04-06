package hello.DugOutTalk.web.post;

import hello.DugOutTalk.domain.team.Team;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    private String nickname;
    private String email;

    private int likes = 0;

    private LocalDateTime createdAt;

    // title 제거 + 생성자 수정
    public Post(Team team, String content, String nickname, String email) {
        if (team == null) throw new IllegalArgumentException("팀 정보가 없습니다!");
        this.team = team;
        this.content = content;
        this.nickname = nickname;
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }

    public void addLike() {
        this.likes++;
    }
    public void removeLike() {
        if (this.likes > 0) this.likes--;
    }


}

