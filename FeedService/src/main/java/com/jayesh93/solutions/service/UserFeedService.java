package com.jayesh93.solutions.service;

import com.jayesh93.solutions.model.Post;
import com.jayesh93.solutions.posts.response.Response;

public interface UserFeedService {

	Response<Post> getPosts(Long userId, int page, int size);

}