package com.jayesh93.solutions.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPostId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;
	private Long postId;

}
