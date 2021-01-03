package com.jayesh93.solutions.repository.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class UserConnectionId implements Serializable{

	private static final long serialVersionUID = 1L;

	@OneToOne
	private UserEntity user;
	
	@OneToOne
	private UserEntity follower;

}
