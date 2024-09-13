package com.eliteartisans.accounts.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Service;

import com.eliteartisans.accounts.constants.AccountsConstants;
import com.eliteartisans.accounts.dto.AccountsDto;
import com.eliteartisans.accounts.dto.CustomerDto;
import com.eliteartisans.accounts.entity.Accounts;
import com.eliteartisans.accounts.entity.Customer;
import com.eliteartisans.accounts.exception.CustomerAlreadyExistsException;
import com.eliteartisans.accounts.exception.ResourceNotFoundException;
import com.eliteartisans.accounts.mapper.AccountsMapper;
import com.eliteartisans.accounts.mapper.CustomerMapper;
import com.eliteartisans.accounts.repository.AccountsRepository;
import com.eliteartisans.accounts.repository.CustomerRepository;
import com.eliteartisans.accounts.service.IAccountsService;

@Service
public class AccountsServiceImpl implements IAccountsService {

	private AccountsRepository accountsRepository;
	private CustomerRepository customerRepository;
	
	public AccountsServiceImpl(AccountsRepository accountsRepository, CustomerRepository customerRepository) {
		super();
		this.accountsRepository = accountsRepository;
		this.customerRepository = customerRepository;
	}
	/**
	 * @param customerDto
	 */
	@Override
	public void createAccount(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
		Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
		if(optionalCustomer.isPresent()) {
			throw new CustomerAlreadyExistsException("Customer already registered with given mobile number"
					+customerDto.getMobileNumber());
		}
		customer.setCreatedAt(LocalDateTime.now());
		customer.setCreatedBy("Anonymous");
		Customer savedCustomer = customerRepository.save(customer);
		accountsRepository.save(createNewAccount(savedCustomer));
	}
	
	/**
     * @param customer - Customer Object
     * @return the new account details
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Annonymous");
        return newAccount;
    }
	@Override
	public CustomerDto fetchAccount(String mobileNumber) {
		Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
				()->new ResourceNotFoundException("Customer", "mobileNumer", mobileNumber));
		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
				()->new ResourceNotFoundException("Accounts", "customerId", String.valueOf(customer.getCustomerId())));
		CustomerDto customerDto =CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
		customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));
		return customerDto;
		
	}
	@Override
	public boolean updateAccount(CustomerDto customerDto) {
		boolean isUpdated = false;
		AccountsDto accountsDto = customerDto.getAccountsDto();
		if(accountsDto!=null) {
			Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
					()->new ResourceNotFoundException("Account", "account number", String.valueOf(accountsDto.getAccountNumber())));		
			AccountsMapper.mapToAccounts(accountsDto,accounts);
			accountsRepository.save(accounts);
			
			Long customerId = accounts.getCustomerId();
			Customer customer = customerRepository.findById(customerId).orElseThrow(
					()->new ResourceNotFoundException("Customer", "CustomerId", customerId.toString()));
			CustomerMapper.mapToCustomer(customerDto, customer);
			customerRepository.save(customer);
			isUpdated=true;
		}
		return isUpdated;
	}
	@Override
	public boolean deleteAccount(String mobileNumber) {
		Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
				()->new ResourceNotFoundException("Customer", "mobileNumer", mobileNumber));
		accountsRepository.deleteByCustomerId(customer.getCustomerId());
		customerRepository.deleteById(customer.getCustomerId());
		return true;
	}
}
