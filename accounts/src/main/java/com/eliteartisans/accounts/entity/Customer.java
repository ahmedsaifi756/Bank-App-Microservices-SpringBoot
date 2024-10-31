package com.eliteartisans.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Customer extends BaseEntity {
	
	@Id@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	@Column@NotNull
	private String name;
	@Column@NotNull
	private String email;
	@Column@NotNull
	private String mobileNumber;
}
