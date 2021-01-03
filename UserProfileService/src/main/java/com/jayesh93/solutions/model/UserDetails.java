package com.jayesh93.solutions.model;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

	private User user;
	private Set<User> followers = new HashSet<>();
	private Set<User> following = new HashSet<>();

	public UserDetails(User user) {
		super();
		this.user = user;
	}

}