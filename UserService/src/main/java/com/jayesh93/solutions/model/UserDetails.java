package com.jayesh93.solutions.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

	private User user;
	private List<User> followers = new ArrayList<>();
	private List<User> following = new ArrayList<>();

	public UserDetails(User user) {
		super();
		this.user = user;
	}
}