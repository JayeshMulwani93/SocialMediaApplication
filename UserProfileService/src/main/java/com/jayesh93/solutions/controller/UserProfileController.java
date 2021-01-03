package com.jayesh93.solutions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh93.solutions.model.Post;
import com.jayesh93.solutions.model.Response;
import com.jayesh93.solutions.model.UserDetails;
import com.jayesh93.solutions.model.UserProfile;
import com.jayesh93.solutions.service.UserInfoService;
import com.jayesh93.solutions.service.UserPostsService;

@RestController
@RequestMapping("/v1/profiles")
public class UserProfileController {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private UserPostsService userPostsService;

	@GetMapping("/{userId}")
	public UserProfile getUserProfile(@PathVariable Long userId) {
		UserDetails userInfo = userInfoService.getUserInfo(userId);
		Response<Post> userPosts = userPostsService.getUserPosts(userId);
		return new UserProfile(userInfo, userPosts.getData());
	}

}