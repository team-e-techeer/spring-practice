package net.schoolvery.schoolveryserver.domain.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetUserResponseDto {

    private int id ;

    private String name;
    private String nickname;
    private int phone;
    private int student_id;
    private String school;
    private String email;
    private String password;
}
