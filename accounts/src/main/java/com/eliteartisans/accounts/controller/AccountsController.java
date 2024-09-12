package com.eliteartisans.accounts.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eliteartisans.accounts.constants.AccountsConstants;
import com.eliteartisans.accounts.dto.CustomerDto;
import com.eliteartisans.accounts.dto.ResponseDto;
import com.eliteartisans.accounts.service.IAccountsService;


@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {
	
	private IAccountsService iAccountsService;
	
	public AccountsController(IAccountsService iAccountsService) {
		super();
		this.iAccountsService = iAccountsService;
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){
		iAccountsService.createAccount(customerDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(AccountsConstants.STATUS_201,AccountsConstants.MESSAGE_201));
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber){
		CustomerDto customerDto = iAccountsService.fetchAccount(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(customerDto);
		
	}
	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateAccountDetails(@RequestBody CustomerDto customerDto){
		boolean isUpdated = iAccountsService.updateAccount(customerDto);
		if(isUpdated) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
		}else{
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseDto(AccountsConstants.STATUS_500,AccountsConstants.MESSAGE_500));
		}
	}
}
