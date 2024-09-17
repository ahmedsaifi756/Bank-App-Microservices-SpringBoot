package com.eliteartisans.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;


public class AccountsDto {
	
	@NotEmpty(message = "account no cannot be null")
	@Pattern(regexp ="(^$|[0-9]{10})",message = "account no should be 10 digit nos")
	private Long accountNumber;
	
	@NotEmpty(message = "account type cannot be null or empty")
	private String accountType;
	
	@NotEmpty(message = "branch adress cannot be empty or null")
	private String branchAddress;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	@Override
	public String toString() {
		return "AccountsDto [accountNumber=" + accountNumber + ", accountType=" + accountType + ", branchAddress="
				+ branchAddress + "]";
	}
}
