package com.dojo.stepDefinition;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.dojo.model.LoginDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@AutoConfigureMockMvc
@CucumberContextConfiguration
@SpringBootTest
public class StepDefinition {
	@Autowired
	MockMvc mockMvc;

	LoginDetail loginDetail;

	private ResultActions action;

	@Given("^user enters valid credential$")
	public void user_enters_valid_credential(){
		loginDetail = new LoginDetail("test", "test1234");
	}

	@Given("^user enters invalid credential$")
	public void user_enters_invalid_credential(){
		loginDetail = new LoginDetail("test", "test");
	}

	@When("^performing login$")
	public void performing_login() throws Exception {
		action = mockMvc.perform(post("/login").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(asJsonString(loginDetail)));

	}

	@Then("^login is successful$")
	public void login_is_successful() throws Exception {
		action.andExpect(status().isOk());
	}

	@Then("^error message displayed$")
	public void error_message_displayed() throws Exception{
		action.andExpect(status().isUnauthorized());
	}

	public static String asJsonString(LoginDetail login) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(login);
	}

}