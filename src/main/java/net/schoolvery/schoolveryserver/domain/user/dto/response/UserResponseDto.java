package net.schoolvery.schoolveryserver.domain.user.dto.response;

import com.sun.istack.NotNull;
import lombok.*;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDto {

    @NotNull
    @Size(max = 255)
    private String firstName;

    @NotNull
    @Size(max = 255)
    private String lastName;

}