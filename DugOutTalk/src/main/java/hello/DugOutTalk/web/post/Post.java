package hello.DugOutTalk.web.post;

import hello.DugOutTalk.domain.team.Team;
import hello.DugOutTalk.web.like.PostLike;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PostLike> postLikes = new ArrayList<>();


    private String nickname;
    private String email;

    private int likes = 0;

    private LocalDateTime createdAt;

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

