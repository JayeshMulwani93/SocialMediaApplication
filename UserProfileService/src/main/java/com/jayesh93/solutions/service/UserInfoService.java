package com.jayesh93.solutions.service;

import com.jayesh93.solutions.model.UserDetails;

public interface UserInfoService {

	UserDetails getFallbackUserInfo(Long userId);

	UserDetails getUserInfo(Long userId);

}
