package com.lattice.latticeredis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-18 21:39
 **/
@Data
public class User implements Serializable {

	private int id;

	private String name;

	private String email;

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
