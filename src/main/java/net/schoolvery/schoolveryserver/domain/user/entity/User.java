package net.schoolvery.schoolveryserver.domain.user.entity;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
//    @NotNull
//    private String email;
//    @Setter
//    @NotNull
//    @Column(length = 128)
//    private String password;
//
//    @NotNull
//    @Column(length = 128)
//    private String phoneNumber;


//    @Builder
//    public User(Long id, String firstName, String lastName, String email, String password, String phoneNumber) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        this.phoneNumber = phoneNumber;
//    }
    public void update(String firstName, String lastName) {

//        this.email = email;
//        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
//        this.phoneNumber = phoneNumber;
    }

}
