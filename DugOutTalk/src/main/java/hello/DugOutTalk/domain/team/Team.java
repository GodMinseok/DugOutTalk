package hello.DugOutTalk.domain.team;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String logoImg;
    private String mascotImg;

    public Team(String name, String logoImg, String mascotImg) {
        this.name = name;
        this.logoImg = logoImg;
        this.mascotImg = mascotImg;
    }
}

