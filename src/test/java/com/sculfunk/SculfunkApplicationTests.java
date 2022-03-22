package com.sculfunk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.tomcat.jni.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.sculfunk.entity.Users;
import com.sculfunk.repository.LoginRepository;

@SpringBootTest(classes = SculfunkApplication.class)
@Transactional
class SculfunkApplicationTests {

	
	@Autowired
	private LoginRepository loginRepository;
	
	@Test
	void login() {
		
		
	}

}
