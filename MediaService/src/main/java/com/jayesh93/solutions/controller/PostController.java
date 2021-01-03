package com.jayesh93.solutions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jayesh93.solutions.controller.request.PostsRequest;
import com.jayesh93.solutions.controller.response.Response;
import com.jayesh93.solutions.model.Post;
import com.jayesh93.solutions.service.PostService;

@RestController
@RequestMapping("/v1")
public class PostController {

	@Autowired
	private PostService service;

	@GetMapping("/posts/{postId}")
	Post getPostInfo(@PathVariable Long postId) {
		return service.getPostInfo(postId);
	}

	@GetMapping("/{userId}/posts")
	Response<Post> getUserPosts(@PathVariable Long userId) {
		return service.getPosts(userId);
	}

	@PostMapping("/posts")
	Post createPost(@RequestBody Post post) {
		return service.createPost(post);
	}

	@PostMapping("/posts/lookup")
	Response<Post> findPostsByIds(@RequestBody PostsRequest posts,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "20") int size) {
		return service.getPosts(posts.getIds(), page, size);
	}
}