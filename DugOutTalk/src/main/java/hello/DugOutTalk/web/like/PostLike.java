package hello.DugOutTalk.web.like;

import hello.DugOutTalk.web.post.Post;
import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity
public class PostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;
}

