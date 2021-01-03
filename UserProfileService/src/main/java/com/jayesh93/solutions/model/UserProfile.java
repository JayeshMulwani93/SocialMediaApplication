package com.jayesh93.solutions.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {

	@JsonUnwrapped
	private UserDetails user;

	private List<Post> posts;

}
