package com.lattice.latticeuser.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.lattice.latticeuser.entity.Permission;

import lombok.Data;
@Data
public class RoleDTO implements Serializable {
    private Integer roleid;

    private String rolename;

    private Date created;

    private Date updated;

    private String status;

    private Set<Permission> permissions;

}