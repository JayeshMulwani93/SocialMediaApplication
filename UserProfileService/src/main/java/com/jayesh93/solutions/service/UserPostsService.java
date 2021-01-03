package com.jayesh93.solutions.service;

import com.jayesh93.solutions.model.Post;
import com.jayesh93.solutions.model.Response;

public interface UserPostsService {

	Response<Post> getFallbackUserPosts(Long userId);

	Response<Post> getUserPosts(Long userId);

}
