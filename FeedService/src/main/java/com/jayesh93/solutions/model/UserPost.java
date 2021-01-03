package com.jayesh93.solutions.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class UserPost {

	@EmbeddedId
	private UserPostId id;

	public UserPost() {
		super();
	}

	public UserPost(UserPostId id) {
		super();
		this.id = id;
	}

	public UserPostId getId() {
		return id;
	}

	public void setId(UserPostId id) {
		this.id = id;
	}

}
