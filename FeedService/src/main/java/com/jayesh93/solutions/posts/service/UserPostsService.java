package com.jayesh93.solutions.posts.service;

import java.util.Set;

import com.jayesh93.solutions.model.Post;
import com.jayesh93.solutions.posts.response.Response;

public interface UserPostsService {

	Response<Post> getPostsWithIds(Set<Long> posts, int page, int size);

}
