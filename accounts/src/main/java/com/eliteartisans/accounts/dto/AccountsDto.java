package com.eliteartisans.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Schema(
		name = "Accounts",
		description = "Schema to hold account information"
		)
public class AccountsDto {
	
	@NotEmpty(message = "account no cannot be null")
	@Pattern(regexp ="(^$|[0-9]{10})",message = "account no should be 10 digit nos")
	@Schema(
			description = "Accoint no of EliteArtisans Bank Account",example = "25648914201"
			)
	private Long accountNumber;
	
	@NotEmpty(message = "account type cannot be null or empty")
	@Schema(
			description = "Account type of ELiteArtisans",example = "Saving"
			)
	private String accountType;
	
	@NotEmpty(message = "branch adress cannot be empty or null")
	@Schema(
			description = "Branch address of ELiteArtisans",example = "124 Jasola Vihar"
			)
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
