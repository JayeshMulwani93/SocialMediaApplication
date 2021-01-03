package com.jayesh93.solutions.service;


import com.jayesh93.solutions.controller.request.UserConnectionRequest;
import com.jayesh93.solutions.controller.request.UserRequest;
import com.jayesh93.solutions.controller.response.Response;
import com.jayesh93.solutions.model.User;
import com.jayesh93.solutions.model.UserDetails;

public interface UserService {

	User registerUser(UserRequest userRequest);

	void addConnection(UserConnectionRequest connectionRequest);

	User getUserInfo(Long userId);

	UserDetails getUserDetails(Long userId);

	Response<User> getFollowers(Long userId, int page, int size);

	Response<User> getFollowing(Long userId, int page, int size);
}