package com.eliteartisans.accounts.service;

import com.eliteartisans.accounts.dto.CustomerDto;

public interface IAccountsService {
	
	/**
	 * 
	 * @param customerDto- CustomerDto Object
	 */
	void createAccount(CustomerDto customerDto);
}
