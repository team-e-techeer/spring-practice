package net.schoolvery.schoolveryserver.domain.user.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserUpdateDto {

    private String name;
    private String nickname;
    private int phone;
    private int student_id;
    private String school;
    private String email;
    private String password;

}
