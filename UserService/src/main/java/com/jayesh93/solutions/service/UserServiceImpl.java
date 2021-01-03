package com.jayesh93.solutions.service;

import static com.jayesh93.solutions.service.mapper.UserEntityMapper.convert;
import static com.jayesh93.solutions.service.mapper.UserEntityMapper.convertFollowers;
import static com.jayesh93.solutions.service.mapper.UserEntityMapper.convertFollowing;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jayesh93.solutions.controller.request.UserConnectionRequest;
import com.jayesh93.solutions.controller.request.UserRequest;
import com.jayesh93.solutions.controller.response.Response;
import com.jayesh93.solutions.model.User;
import com.jayesh93.solutions.model.UserDetails;
import com.jayesh93.solutions.repository.ConnectionRepository;
import com.jayesh93.solutions.repository.UserRepository;
import com.jayesh93.solutions.repository.entities.UserConnectionEntity;
import com.jayesh93.solutions.repository.entities.UserConnectionId;
import com.jayesh93.solutions.repository.entities.UserEntity;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ConnectionRepository userConnectionRepository;

	@Override
	public User registerUser(UserRequest userRequest) {
		return convert(userRepository.save(new UserEntity(userRequest.getFullName(), userRequest.getUserName(),
				userRequest.getEmailId(), userRequest.getDateOfBirth())));
	}

	@Override
	public void addConnection(UserConnectionRequest connectionRequest) {
		if (connectionRequest.getUserId() == connectionRequest.getFollowerId()) {
			// TODO Create a Custom Exception
			throw new RuntimeException();
		}

		Optional<UserEntity> userOptional = userRepository.findById(connectionRequest.getUserId());
		Optional<UserEntity> followerOptional = userRepository.findById(connectionRequest.getFollowerId());

		if (userOptional.isPresent() && followerOptional.isPresent()) {
			UserEntity user = userOptional.get();
			UserConnectionEntity connection = new UserConnectionEntity(
					new UserConnectionId(user, followerOptional.get()));
			if (!user.getFollowers().contains(connection)) {
				user.getFollowers().add(connection);
				userRepository.save(user);
			} else {
				// TODO Create a Custom Exception
				throw new RuntimeException();
			}
		}
	}

	@Override
	public User getUserInfo(Long userId) {
		Optional<UserEntity> userOptional = userRepository.findById(userId);
		if (userOptional.isPresent()) {
			return convert(userOptional.get());
		}
		return null;
	}

	@Override
	public UserDetails getUserDetails(Long userId) {
		User user = getUserInfo(userId);
		if (user != null) {
			UserDetails userDetails = new UserDetails(user);
			List<UserConnectionEntity> followersConnectionEntities = userConnectionRepository.findAllByIdUserId(userId);
			List<User> followerConnections = convertFollowers(followersConnectionEntities);

			List<UserConnectionEntity> followingConnectionEntities = userConnectionRepository
					.findAllByIdFollowerId(userId);
			List<User> followingConnections = convertFollowing(followingConnectionEntities);

			userDetails.setFollowers(followerConnections);
			userDetails.setFollowing(followingConnections);
			return userDetails;
		}
		return null;
	}

	@Override
	public Response<User> getFollowers(Long userId, int page, int size) {

		List<UserConnectionEntity> connections = userConnectionRepository.findAllById_UserId(userId,
				PageRequest.of(page, size));

		return new Response<User>(convertFollowers(connections));
	}

	@Override
	public Response<User> getFollowing(Long userId, int page, int size) {

		List<UserConnectionEntity> connections = userConnectionRepository.findAllByIdFollowerId(userId,
				PageRequest.of(page, size));

		return new Response<User>(convertFollowing(connections));
	}

}