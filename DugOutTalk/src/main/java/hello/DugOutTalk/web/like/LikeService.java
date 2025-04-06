package hello.DugOutTalk.web.like;

import org.springframework.stereotype.Service;
import hello.DugOutTalk.domain.member.Member;
import hello.DugOutTalk.web.post.Post;
import hello.DugOutTalk.web.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;

    @Transactional
    public void likePost(Long postId, Member user) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        Optional<PostLike> existingLike = postLikeRepository.findByUserAndPost(user, post);
        if (existingLike.isPresent()) {
            // 좋아요 취소
            postLikeRepository.delete(existingLike.get());
            post.removeLike();
        } else {
            // 좋아요 누르기
            PostLike like = new PostLike(user, post);
            postLikeRepository.save(like);
            post.addLike();
        }
    }
}


