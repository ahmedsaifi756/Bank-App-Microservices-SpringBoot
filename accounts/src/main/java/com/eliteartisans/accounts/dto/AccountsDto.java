package com.eliteartisans.accounts.dto;


public class AccountsDto {
	
	private long accountNumber;
	
	private String accountType;
	
	private String branchAddress;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
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
