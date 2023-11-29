package com.prakash.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMP_DTLS")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Please Enter Name")
	private String name;

	@Email(message = "Enter a valid Email id")
	@NotEmpty(message = "Please Enter Email")
	private String email;

	@NotEmpty(message = "Please Enter Address")
	private String address;

	@NotEmpty(message = "Please Enter Gender")
	private String gender;

	@NotEmpty(message = "Please Enter Password")
	private String password;

}
