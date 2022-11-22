package com.dojo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dojo.model.AuthResponse;
import com.dojo.model.LoginDetail;
import com.dojo.model.UserToken;
import com.dojo.service.UserServiceImpl;

@SpringBootTest(classes= {LoginControllerTest.class})
public class LoginControllerTest {
	
	@Mock
	UserServiceImpl userServiceImpl;
	
	@InjectMocks
	LoginController loginController;
	
	@Test
	void test_login() {
//		given
		LoginDetail user = new LoginDetail("test","test1234");
//		when
		ResponseEntity<UserToken> login = loginController.login(user); 	
//		then
		assertEquals(HttpStatus.OK, login.getStatusCode());
	}
	
	@Test
	void test_getValidity() {
//		given
		String token = "test";
		given(userServiceImpl.getValidity(token)).willReturn(new AuthResponse("test", true));
//		when
		ResponseEntity<AuthResponse> validity = loginController.getValidity("test");
//		then
		assertTrue(validity.getBody().isValid());
		
		
	}
	@Test
	void test_welcome() {
		loginController.welcome();
	}
}
