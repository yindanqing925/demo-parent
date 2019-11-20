package org.nh.service.base.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Integer id;

    private String username;

    private String password;

    private Double balance;

    private Date created;

    private Date updated;

    private Integer address;

    private String phone;

    private String tips;

}