package net.schoolvery.schoolveryserver.domain.user.entity;


import com.sun.istack.NotNull;
import lombok.*;
import net.schoolvery.schoolveryserver.global.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    public void update(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
