package hello.DugOutTalk.domain.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotEmpty
    private String loginId;

    @Column(nullable = false)
    @NotEmpty
    private String name;

    @Column(nullable = false, unique = true)
    @NotEmpty
    private String email;

    @Column(nullable = false)
    @NotEmpty
    private String favoriteTeam;

    @Column(nullable = false, unique = true)
    @NotEmpty
    private String nickName;

    @Column(nullable = false)
    @NotEmpty
    private String password; // 비밀번호는 암호화하여 저장

//    public void encodePassword(PasswordEncoder passwordEncoder) {
//        this.password = passwordEncoder.encode(this.password);
//    }
}
