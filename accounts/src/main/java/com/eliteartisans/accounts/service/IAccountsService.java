package com.eliteartisans.accounts.service;

import com.eliteartisans.accounts.dto.CustomerDto;

public interface IAccountsService {
	
	/**
	 * @param customerDto- CustomerDto Object
	 */
	void createAccount(CustomerDto customerDto);
	/**
	 * 
	 * @param mobileNumer Input Mobile Number
	 * @return Accounts details based on mobile Number
	 */
	CustomerDto fetchAccount(String mobileNumer);
	/**
	 *  @param customerDto input customer DTO details
	 * @return true/false based on requirement
	 */	
	boolean updateAccount(CustomerDto customerDto);
	/**
	 * 
	 * @param mobileNumber Input mobile number
	 * @return boolean indicating if the delete account is succesful or not
	 */
	boolean deleteAccount(String mobileNumber);
}
