package com.jayesh93.solutions.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayesh93.solutions.model.Post;
import com.jayesh93.solutions.model.UserPost;
import com.jayesh93.solutions.model.UserPostId;
import com.jayesh93.solutions.posts.response.Response;
import com.jayesh93.solutions.repository.UserPostRepository;
import com.jayesh93.solutions.userdetails.model.User;
import com.jayesh93.solutions.userdetails.service.UserDetailsService;

@Service
public class FeedGenerationServiceImpl implements FeedGenerationService {

	@Autowired
	private UserPostRepository repository;

	@Autowired
	private UserDetailsService userService;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	@KafkaListener(topics = "posts")
	public void consume(Post post) throws IOException {
		Long userId = post.getUserId();

		// Find All Followers for this User & add followerPosts in database
		Response<User> response = userService.getUserFollowers(userId);

		System.out.println(objectMapper.writeValueAsString(response));

		List<UserPost> followerPosts = response.getData().stream().map((user) -> {
			return new UserPost(new UserPostId(user.getId(), post.getId()));
		}).collect(Collectors.toList());

		repository.saveAll(followerPosts);
	}
}
