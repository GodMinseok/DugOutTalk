package hello.DugOutTalk.domain.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "아이디를 입력해주세요.")
    private String loginId;

    @Column(nullable = false)
    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "좋아하는 팀을 입력해주세요.")
    private String favoriteTeam;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "닉네임을 입력해주세요.")
    private String nickName;

    @Column(nullable = false)
    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
    private String password;

    @Transient
    @NotBlank(message = "비밀번호 확인을 위해 입력해주세요.")
    private String confirmPassword;

    @Column(nullable = false)
    private String favoriteTeamLogo; // 팀 로고 URL 저장

//    public void encodePassword(PasswordEncoder passwordEncoder) {
//        this.password = passwordEncoder.encode(this.password);
//    }
}
