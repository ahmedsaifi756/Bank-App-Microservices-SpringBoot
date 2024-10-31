package com.eliteartisans.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString
@Entity
public class Accounts extends BaseEntity {
	@Column@NotNull
	private long customerId;
	@Id@Column
	private long accountNumber;
	@Column@NotNull
	private String accountType;
	@Column@NotNull
	private String branchAddress;
}
