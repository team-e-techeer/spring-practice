package net.schoolvery.schoolveryserver.domain.user.dto;

import com.sun.istack.NotNull;
import lombok.*;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    @NotNull
    @Size(max = 255)
    private String firstName;

    @NotNull
    @Size(max = 255)
    private String lastName;

}

