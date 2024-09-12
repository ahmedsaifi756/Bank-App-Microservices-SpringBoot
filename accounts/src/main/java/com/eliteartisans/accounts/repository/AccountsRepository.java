package com.eliteartisans.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eliteartisans.accounts.entity.Accounts;
import com.eliteartisans.accounts.entity.Customer;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long>{

	Optional<Accounts> findByCustomerId(long customerId);
	
}
