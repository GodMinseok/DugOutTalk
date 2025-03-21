package hello.DugOutTalk.domain.member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Member {

    private Long id;

    @NotEmpty
    private String loginId; //로그인 ID

    @NotEmpty
    private String name; //사용자 이름

    @NotEmpty
    private String password;

    @NotEmpty
    private String email; //이메일

    @NotEmpty
    private String favoriteTeam; //응원하는 팀

    @NotEmpty
    private String nickName; //닉네임
}
