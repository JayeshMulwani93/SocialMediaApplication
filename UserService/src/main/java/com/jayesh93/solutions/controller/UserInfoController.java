package com.jayesh93.solutions.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh93.solutions.controller.request.UserConnectionRequest;
import com.jayesh93.solutions.controller.request.UserRequest;
import com.jayesh93.solutions.controller.response.Response;
import com.jayesh93.solutions.model.User;
import com.jayesh93.solutions.model.UserDetails;
import com.jayesh93.solutions.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserInfoController {

	@Autowired
	private UserService userService;

	@PostMapping
	User registerUser(@RequestBody @Valid UserRequest userRequest) {
		return userService.registerUser(userRequest);
	}

	@PostMapping("/connections")
	void addConnection(@RequestBody UserConnectionRequest connectionRequest) {
		userService.addConnection(connectionRequest);
	}

	@GetMapping("/{userId}/details")
	UserDetails getUserDetails(@PathVariable Long userId) {
		return userService.getUserDetails(userId);
	}

	@GetMapping("/{userId}")
	User getUserInfo(@PathVariable Long userId) {
		return userService.getUserInfo(userId);
	}

	@GetMapping("/{userId}/followers")
	Response<User> getUserFollowers(@PathVariable Long userId, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int size) {
		return userService.getFollowers(userId, page, size);
	}

	@GetMapping("/{userId}/following")
	Response<User> getUserFollowing(@PathVariable Long userId, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int size) {
		return userService.getFollowing(userId, page, size);
	}
}