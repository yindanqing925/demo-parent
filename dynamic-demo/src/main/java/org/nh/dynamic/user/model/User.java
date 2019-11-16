package org.nh.dynamic.user.model;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;

    private String usernname;

    private String password;

    private Double balance;

    private Date created;

    private Date updated;

    private Integer adress;

    private String phone;

    private String tips;

}