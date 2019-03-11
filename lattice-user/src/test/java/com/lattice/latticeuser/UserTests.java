package com.lattice.latticeuser;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lattice.latticecommon.result.LayUiResultData;
import com.lattice.latticeuser.controller.UserController;
import com.lattice.latticeuser.entity.User;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

	@Autowired
	private UserController userController;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testAddUser(){
		User user = new User();
		user.setOpenid("1232321");
		user.setUsername("zhang");
		user.setPassword("asdsad");
		user.setName("张家豪");
		LayUiResultData insert = userController.insert(user);
		System.out.println(insert);
		assert (((User)insert.getData()).getUserid() != null);

	}

}
