package com.jayesh93.solutions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

	private PostType type = PostType.IMAGE;

	private int id;
	private String caption;
	private String location;
	private String imageUrl;
	private int userId;
	private String image;

	public Post(int id, String caption, String location, String imageUrl, int userId) {
		super();
		this.id = id;
		this.caption = caption;
		this.location = location;
		this.imageUrl = imageUrl;
		this.userId = userId;
	}

	public Post(int id, String image, int userId) {
		super();
		this.id = id;
		this.image = image;
		this.userId = userId;
	}

}
