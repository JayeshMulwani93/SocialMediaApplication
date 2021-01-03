package com.jayesh93.solutions.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jayesh93.solutions.repository.entities.UserConnectionEntity;
import com.jayesh93.solutions.repository.entities.UserConnectionId;

@Repository
public interface ConnectionRepository extends PagingAndSortingRepository<UserConnectionEntity, UserConnectionId> {

	List<UserConnectionEntity> findAllByIdUserId(Long userId);

	List<UserConnectionEntity> findAllById_UserId(Long userId, Pageable pageable);

	List<UserConnectionEntity> findAllByIdFollowerId(Long userId);

	List<UserConnectionEntity> findAllByIdFollowerId(Long userId, Pageable pageable);
}