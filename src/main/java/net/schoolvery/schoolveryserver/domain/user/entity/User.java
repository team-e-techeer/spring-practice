package net.schoolvery.schoolveryserver.domain.user.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name="user_test")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id = UUID.randomUUID();

    private String name;
    private String nickname;
    private int phone;
    private int student_id;
    private String school;
    private String email;
    private String password;

    public User(String name, String nickname, int phone, int student_id, String school, String email, String password) {
        this.name = name;
        this.nickname = nickname;
        this.phone = phone;
        this.student_id = student_id;
        this.school = school;
        this.email = email;
        this.password = password;
    }
}
