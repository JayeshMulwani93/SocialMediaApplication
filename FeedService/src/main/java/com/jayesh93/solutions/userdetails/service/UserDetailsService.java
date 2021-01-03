package com.jayesh93.solutions.userdetails.service;

import com.jayesh93.solutions.posts.response.Response;
import com.jayesh93.solutions.userdetails.model.User;

public interface UserDetailsService {

	Response<User> getUserFollowers(Long userId);

}