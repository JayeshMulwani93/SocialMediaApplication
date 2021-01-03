package com.jayesh93.solutions.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.jayesh93.solutions.controller.response.Response;
import com.jayesh93.solutions.model.Post;

public interface PostService {
	Post getPostInfo(Long postId);

	Post createPost(@RequestBody Post post);

	Response<Post> getPosts(List<Long> postIds, int page, int size);

	Response<Post> getPosts(Long userId);
}
