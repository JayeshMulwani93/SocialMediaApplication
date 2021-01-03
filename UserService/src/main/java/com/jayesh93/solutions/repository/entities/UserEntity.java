package com.jayesh93.solutions.repository.entities;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String fullName;
	private String userName;
	private String emailId;
	private LocalDate dateOfBirth;
	
	private ZonedDateTime creationDateTime = ZonedDateTime.now();

	@OneToMany(mappedBy = "id.user", cascade = CascadeType.ALL)
	private List<UserConnectionEntity> followers;

	@OneToMany(mappedBy = "id.follower", cascade = CascadeType.ALL)
	private List<UserConnectionEntity> following;

	public UserEntity(String fullName, String userName, String emailId, LocalDate dateOfBirth) {
		this.fullName = fullName;
		this.userName = userName;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
	}

}
