package hello.DugOutTalk.web.like;

import hello.DugOutTalk.domain.member.Member;
import hello.DugOutTalk.web.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    Optional<PostLike> findByUserAndPost(Member user, Post post);
    void deleteByPostId(Long postId);
}

