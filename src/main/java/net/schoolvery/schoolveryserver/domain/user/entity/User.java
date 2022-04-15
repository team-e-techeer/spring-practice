package net.schoolvery.schoolveryserver.domain.user.entity;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String school;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Integer email_validation;

    @Column(nullable = false)
    private Integer password;

    @Column(nullable = false)
    private Integer provider;

    @Column(nullable = false)
    private Integer profile_image_url;

    @Column(nullable = false)
    private Integer phone_num;
}