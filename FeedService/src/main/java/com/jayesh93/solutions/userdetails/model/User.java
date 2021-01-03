package com.jayesh93.solutions.userdetails.model;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Long id;

	private String fullName;

	private String userName;

	private String emailId;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateOfBirth;

	private ZonedDateTime creationDateTime;
}