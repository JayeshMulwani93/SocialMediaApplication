package com.jayesh93.solutions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jayesh93.solutions.controller.response.Response;
import com.jayesh93.solutions.messaging.PostProducerService;
import com.jayesh93.solutions.model.Post;
import com.jayesh93.solutions.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostProducerService postProducerService;

	@Autowired
	private PostRepository repository;

	@Override
	public Post getPostInfo(Long postId) {
		Optional<Post> postOptional = repository.findById(postId);
		if (postOptional.isPresent()) {
			return postOptional.get();
		}
		return null;
	}

	@Override
	public Response<Post> getPosts(Long userId) {
		return new Response<Post>(repository.findByUserId(userId));
	}

	@Override
	public Post createPost(Post post) {
		Post savedPost = repository.save(post);
		postProducerService.send(savedPost);
		return savedPost;
	}

	@Override
	public Response<Post> getPosts(List<Long> postIds, int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by("updationDateTime").descending());
		return new Response<Post>(repository.findByIdIn(postIds, pageRequest));
	}

}
