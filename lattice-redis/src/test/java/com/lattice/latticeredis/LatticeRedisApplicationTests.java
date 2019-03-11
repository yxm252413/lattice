package com.lattice.latticeredis;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lattice.latticeredis.controller.TestController;
import com.lattice.latticeredis.entity.User;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class LatticeRedisApplicationTests {
	private Logger logger = LoggerFactory.getLogger("test");

	@Autowired
	private TestController testController;

	@Test
	public void contextLoads() throws InterruptedException {
		User user = new User();
		user.setId(123456789);
		user.setEmail("961099916@qq.com");
		user.setName("zjh");
		testController.delete(user.getId());
		testController.addUser(user);
		for (int i = 0; i < 10; i++) {
			logger.info("user-"+i+"\t"+testController.findById(123456789).toString());

			Thread.sleep(1000);
		}

	}

	@Test
	public void getUser() throws InterruptedException {

		for (int i = 0; i < 10; i++) {
			logger.info("user-"+i+"\t"+testController.findById(123456789).toString());

			Thread.sleep(1000);
		}
	}

}
