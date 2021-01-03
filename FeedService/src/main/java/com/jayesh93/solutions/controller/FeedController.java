package com.jayesh93.solutions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh93.solutions.model.Post;
import com.jayesh93.solutions.posts.response.Response;
import com.jayesh93.solutions.service.UserFeedService;

@RestController
@RequestMapping("/v1/userfeed")
public class FeedController {

	@Autowired
	private UserFeedService userFeedService;

	@GetMapping("/{userId}")
	public Response<Post> getUserFeed(@PathVariable Long userId,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "20") int size) {
		return userFeedService.getPosts(userId, page, size);
	}
}