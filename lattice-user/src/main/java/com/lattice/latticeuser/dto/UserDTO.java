package com.lattice.latticeuser.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.lattice.latticeuser.entity.Log;

import lombok.Data;
@Data
public class UserDTO implements Serializable {
    private Integer userid;

    private String username;

    private String password;

    private String openid;

    private String name;

    private String status;

    private String email;

    private String phone;

    private Integer grade;

    private Date updated;

    private Date created;

    private RoleDTO roleDTO;

    private Set<Log> logs;


}