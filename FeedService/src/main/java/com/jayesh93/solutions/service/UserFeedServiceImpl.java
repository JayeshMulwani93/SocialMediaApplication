package com.jayesh93.solutions.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayesh93.solutions.model.Post;
import com.jayesh93.solutions.model.UserPost;
import com.jayesh93.solutions.posts.response.Response;
import com.jayesh93.solutions.posts.service.UserPostsService;
import com.jayesh93.solutions.repository.UserPostRepository;

@Service
public class UserFeedServiceImpl implements UserFeedService {

	@Autowired
	private UserPostRepository repository;

	@Autowired
	private UserPostsService postService;

	@Override
	public Response<Post> getPosts(Long userId, int page, int size) {
		List<UserPost> userPosts = repository.findById_UserId(userId);
		Set<Long> postIds = userPosts.stream().map((UserPost userPost) -> userPost.getId().getPostId())
				.collect(Collectors.toSet());
		return postService.getPostsWithIds(postIds, page, size);
	}
}
