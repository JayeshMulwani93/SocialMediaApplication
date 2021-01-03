package com.jayesh93.solutions.model;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

	private PostType type = PostType.IMAGE;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String caption;
	private String location;
	private String imageUrl;
	

	@NotNull
	private Long userId;
	private ZonedDateTime creationDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
	private ZonedDateTime updationDateTime = ZonedDateTime.now(ZoneId.of("UTC"));

	@NotBlank
	@Lob
	private String image;

	public Post(Long id, String caption, String location, String imageUrl, Long userId) {
		super();
		this.id = id;
		this.caption = caption;
		this.location = location;
		this.imageUrl = imageUrl;
		this.userId = userId;
	}

	public Post(Long id, String imageUrl, Long userId) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.userId = userId;
	}

}
