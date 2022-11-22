package com.dojo.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.MissingRequestHeaderException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;


@SpringBootTest(classes = {RestExceptionHandlerTest.class})
public class RestExceptionHandlerTest {
	
	RestExceptionHandler restExceptionHandler;
	
	@BeforeEach
	void init() {
		restExceptionHandler = new RestExceptionHandler();
	}
	

	@Test
	void test_handleUnauthorizedExceptions() {
		UnauthorizedException ex = new UnauthorizedException("Test_handleUnauthorizedException");
		restExceptionHandler.handleUnauthorizedExceptions(ex);
		
	}
	
	@Test
	void test_handleMissingRequestHeaderException() {
		MethodParameter methodParameter = null;
		MissingRequestHeaderException ex = new MissingRequestHeaderException("TestHeaderName",methodParameter);
		restExceptionHandler.handleMissingRequestHeaderException(ex);
	}
	
	@Test
	void test_handleExpiredJwtException() {
		Header header = null;
		Claims claims= null;
		String message = "test";
		ExpiredJwtException expiredJwtException = new ExpiredJwtException(header, claims, message);
		assertEquals(message, restExceptionHandler.handleExpiredJwtException(expiredJwtException).getBody().getMessage());
	}
	
	@Test
	void test_constraintException() {
		String message = "test";
		ConstraintException constraintException = new ConstraintException(message);
		restExceptionHandler.handleConstraintException(constraintException);
		assertEquals(message, restExceptionHandler.handleConstraintException(constraintException).getBody().getMessage());
	}
	
	@Test
	void handleUserNotFoundException() {
		String message = "test";
		UserNotFoundException constraintException = new UserNotFoundException(message);
		assertEquals(message, restExceptionHandler.handleUserNotFound(constraintException).getBody().getMessage());
	}
	@Test
	void handleNullPonterException() {
		NullPointerException nullPointerException = new NullPointerException();
		assertEquals("One or more fields are null",restExceptionHandler.handleNullPointerException(nullPointerException).getBody().getMessage()); 
		
	}
	
	
}
