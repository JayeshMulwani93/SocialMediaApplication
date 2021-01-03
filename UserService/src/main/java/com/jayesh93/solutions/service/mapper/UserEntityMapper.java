package com.jayesh93.solutions.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.jayesh93.solutions.model.User;
import com.jayesh93.solutions.repository.entities.UserConnectionEntity;
import com.jayesh93.solutions.repository.entities.UserEntity;

public class UserEntityMapper {

	public static List<User> convertFollowers(List<UserConnectionEntity> connections) {

		return connections.stream()
				.map(connection -> connection.getId().getFollower())
				.map(userentity -> convert(userentity))
				.collect(Collectors.toList());
	}

	public static List<User> convertFollowing(List<UserConnectionEntity> connections) {
		return connections.stream()
				.map(connection -> connection.getId().getUser())
				.map(userentity -> convert(userentity))
				.collect(Collectors.toList());
	}

	public static User convert(UserEntity user) {
		return new User(user.getId(), user.getFullName(), user.getUserName(), user.getEmailId(), user.getDateOfBirth(),
				user.getCreationDateTime());
	}
}
