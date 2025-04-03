package hello.DugOutTalk.web.post;


import hello.DugOutTalk.domain.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTeam(Team team);
}
