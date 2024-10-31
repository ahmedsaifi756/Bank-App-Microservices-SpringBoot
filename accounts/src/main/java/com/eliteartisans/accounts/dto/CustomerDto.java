package com.eliteartisans.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Schema(
		name = "Customer",
		description = "Schema to hold customer & account information"
		)
@Getter
@Setter
@ToString
public class CustomerDto {
	@Schema(
            description = "Name of the customer", example = "Mohd Ahmed"
    )
	@NotEmpty(message = "name cannot be null or empty")
	@Size(min = 5, max = 30, message = "the length of the customer name should be between 5 to 30 charactor only")
	private String name;
	@NotEmpty(message = "Email cannot be empty or null")
	@Email(message = "Email address should be valid")
	@Schema(
            description = "Email of the customer", example = "xyz@gmail.com"
    )
	private String email;	
	@Pattern(regexp ="(^$|[0-9]{10})",message = "mobile no should be 10 digit nos")
	@Schema(
            description = "Mobile no  of the customer", example = "12345678910"
    )
	private String mobileNumber;
	
	private AccountsDto accountsDto;
}
