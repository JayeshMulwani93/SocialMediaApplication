package com.jayesh93.solutions.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jayesh93.solutions.model.Post;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

	List<Post> findByIdIn(List<Long> postIds, Pageable pageRequest);

	List<Post> findByUserId(Long userId);
}