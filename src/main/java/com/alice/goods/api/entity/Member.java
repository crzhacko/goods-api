package com.alice.goods.api.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique =true , nullable = false)
    private Integer uid;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String nickname;
    @Column(length = 100, nullable = false)
    private String password;
    @Column(length = 20, nullable = false)
    private String phone;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 1)
    private String sex;
}
