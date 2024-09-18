package com.eliteartisans.accounts.controller;

import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eliteartisans.accounts.constants.AccountsConstants;
import com.eliteartisans.accounts.dto.CustomerDto;
import com.eliteartisans.accounts.dto.ErrorResponseDto;
import com.eliteartisans.accounts.dto.ResponseDto;
import com.eliteartisans.accounts.service.IAccountsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

@Tag(
		name = "CRUD REST APIs for accont in EliteArtisans",
		description = "CRUD REST APIs in EazyBank to CREATE, UPDATE, FETCH AND DELETE account details"
		)
@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class AccountsController {
	
	private IAccountsService iAccountsService;
	public AccountsController(IAccountsService iAccountsService) {
		super();
		this.iAccountsService = iAccountsService;
	}
	@Operation(
			summary = "Create account REST APIs",
			description = "Rest Api to create new Customer & Account inside eliteAritisans"
			)
	@ApiResponses({
		@ApiResponse(
				responseCode = "201",
				description = "HTTP status CREATED"
				),
		@ApiResponse(
				responseCode = "500",
				description = "HTTP Status Internal Server Error",
				content = @Content(
						schema = @Schema(implementation = ErrorResponseDto.class)
						)
				)
	}
	)
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto){
		iAccountsService.createAccount(customerDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(AccountsConstants.STATUS_201,AccountsConstants.MESSAGE_201));
	}
	@Operation(
			summary = "Fetch account REST APIs",
			description = "Rest Api to fetch Existing Customer & Account details based on mobile number"
			)
	@ApiResponses({
		@ApiResponse(
				responseCode = "200",
				description = "HTTP status OK"
				),
		@ApiResponse(
				responseCode = "500",
				description = "HTTP stutus Internal Server Error",
				content = @Content(
						schema = @Schema(implementation = ErrorResponseDto.class)
						)				
				)
		}
	)
	@GetMapping("/fetch")
	public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam
										@Pattern(regexp ="(^$|[0-9]{10})",message = "mobile no should be 10 digit nos") 
										String mobileNumber){
		CustomerDto customerDto = iAccountsService.fetchAccount(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(customerDto);
		
	}
	@Operation(
			summary = "Update account REST APIs",
			description = "Rest Api to update Existing Customer & Account details based on account number"
			)
	@ApiResponses({
		@ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK"
        ),
        @ApiResponse(
                responseCode = "417",
                description = "Expectation Failed"
        ),
        @ApiResponse(
                responseCode = "500",
                description = "HTTP Status Internal Server Error",
                content = @Content(
                        schema = @Schema(implementation = ErrorResponseDto.class)
                ))		
	})
	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateAccountDetails(@Valid @RequestBody CustomerDto customerDto){
		boolean isUpdated = iAccountsService.updateAccount(customerDto);
		if(isUpdated) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
		}else{
			return ResponseEntity
					.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseDto(AccountsConstants.STATUS_417,AccountsConstants.MESSAGE_417_UPDATE));
		}
	}
	@Operation(
			summary = "Delete account REST APIs",
			description = "Rest Api to delete Existing Customer & Account inside eliteAritisans"
			)
	@ApiResponses({
		@ApiResponse(
				responseCode = "200",
				description = "HTTP status OK"
				),
		@ApiResponse(
				responseCode = "500",
				description = "HTTP status internal server Error",
						content = @Content(
	                            schema = @Schema(implementation = ErrorResponseDto.class)
	                    )
				),
		@ApiResponse(
				responseCode = "417",
				description = "Expectation Failed"
				)
	})
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDto> deleteAccountDetails(@RequestParam 
											@Pattern(regexp ="(^$|[0-9]{10})",message = "mobile no should be 10 digit nos")
											String mobileNumber){
		boolean isDeleted = iAccountsService.deleteAccount(mobileNumber);
		if(isDeleted) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
		}else{
			return ResponseEntity
					.status(HttpStatus.EXPECTATION_FAILED)
					.body(new ResponseDto(AccountsConstants.STATUS_417,AccountsConstants.MESSAGE_417_DELETE));
		}
	}
	
}
