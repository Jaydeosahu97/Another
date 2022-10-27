package com.dojo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CustomerDetailsDTO {

	@Id
	private String username;
	@NotBlank
	private String password;
	@NotBlank
    private String name;
	@NotBlank
    private String address;
	@NotBlank
    private String state;
	@NotBlank
    private String country;
	@NotBlank
	@Email(message = "email is not valid")
    private String email;
	@NotBlank
    private String PAN;
	@Column(length = 10)
    private long contactNumber;
	@NotNull
    private LocalDate DOB;
	@NotBlank
    private String accountType;
	
	
}
