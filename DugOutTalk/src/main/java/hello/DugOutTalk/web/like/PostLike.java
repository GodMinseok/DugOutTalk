package hello.DugOutTalk.web.like;

import hello.DugOutTalk.domain.member.Member;
import hello.DugOutTalk.web.post.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member user;

    @ManyToOne
    private Post post;

    public PostLike(Member user, Post post) {
        this.user = user;
        this.post = post;
    }
}


