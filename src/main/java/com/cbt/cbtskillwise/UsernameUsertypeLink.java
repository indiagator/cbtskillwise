package com.cbt.cbtskillwise;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "username_usertype_link")
public class UsernameUsertypeLink {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "usertype", length = 50)
    private String usertype;

}