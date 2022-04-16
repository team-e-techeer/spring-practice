package net.schoolvery.schoolveryserver.domain.user.entity;

import lombok.*;
import javax.persistence.*;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    private int id ;

    private String name;
    private String nickname;
    private int phone;
    private int student_id;
    private String school;
    private String email;
    private String password;


}
