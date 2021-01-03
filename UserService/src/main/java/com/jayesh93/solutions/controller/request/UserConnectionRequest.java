package com.jayesh93.solutions.controller.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserConnectionRequest {

	@NotNull
	private long userId;

	@NotNull
	private long followerId;

}
