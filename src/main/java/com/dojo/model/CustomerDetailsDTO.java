package com.dojo.model;

import java.time.LocalDate;
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

	private String username;
	private String password;
    private String name;
    private String address;
    private String state;
    private String country;
    private String email;
    private String PAN;
    private long contactNumber;
    private LocalDate DOB;
    private String accountType;
	
	
}
