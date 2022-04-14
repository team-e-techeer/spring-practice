package net.schoolvery.schoolveryserver.domain.user.dto.request;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserCreateDto {

    private String name;
    private String nickname;
    private int phone;
    private int student_id;
    private String school;
    private String email;
    private String password;


}
