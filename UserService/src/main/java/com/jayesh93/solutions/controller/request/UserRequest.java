package com.jayesh93.solutions.controller.request;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

	@NotBlank
	private String userName;

	@NotBlank
	private String fullName;

	@NotBlank
	@Email
	private String emailId;

	@NotNull
	private LocalDate dateOfBirth;
}
