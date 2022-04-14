package net.schoolvery.schoolveryserver.domain.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserLoginResponseDto {

    private String email;
    private String password;
}
