package com.jayesh93.solutions.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jayesh93.solutions.model.UserPost;
import com.jayesh93.solutions.model.UserPostId;

@Repository
public interface UserPostRepository extends PagingAndSortingRepository<UserPost, UserPostId> {

	List<UserPost> findById_UserId(Long userId);
}