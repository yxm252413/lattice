package com.lattice.latticeredis.controller;

import com.lattice.latticeredis.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-18 21:37
 **/
@RestController
public class TestController {

	private Logger log = LoggerFactory.getLogger(TestController.class);
	private final Map<Integer, User> db = new HashMap<>();

	@RequestMapping("/add")
	public void addUser(User user) {
		log.info("addUser.user = " + user);
		db.put(user.getId(), user);
	}

	@Cacheable(cacheNames = "user_cache", key = "#id")
	@RequestMapping("/get")
	public User findById(int id) {
		log.info("findById.id = " + id);
		return db.get(id);
	}

	@CacheEvict(cacheNames = "user_cache", key = "#id")
	public void delete(int id) {
		log.info("delete.id = " + id);
		db.remove(id);
	}

}
