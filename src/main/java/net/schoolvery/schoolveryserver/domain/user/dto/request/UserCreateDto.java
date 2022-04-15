package net.schoolvery.schoolveryserver.domain.user.dto.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    private UUID id;
    private String name;
    private String school;
    private String email;
    private Integer email_validation;
    private Integer password;
    private Integer provider;
    private Integer profile_image_url;
    private Integer phone_num;
}
