package com.eliteartisans.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CustomerDto {
	
	@NotEmpty(message = "name cannot be null or empty")
	@Size(min = 5, max = 30, message = "the length of the customer name should be between 5 to 30 charactor only")
	private String name;
	@NotEmpty(message = "Email cannot be empty or null")
	@Email(message = "Email address should be valid")
	private String email;	
	@Pattern(regexp ="(^$|[0-9]{10})",message = "mobile no should be 10 digit nos")
	private String mobileNumber;
	
	private AccountsDto accountsDto;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public AccountsDto getAccountsDto() {
		return accountsDto;
	}

	public void setAccountsDto(AccountsDto accountsDto) {
		this.accountsDto = accountsDto;
	}

	@Override
	public String toString() {
		return "CustomerDto [name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber + ", accountsDto="
				+ accountsDto + "]";
	}

	
	
}
