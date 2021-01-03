package com.jayesh93.solutions.service;

import java.io.IOException;

import com.jayesh93.solutions.model.Post;

public interface FeedGenerationService {

	void consume(Post post) throws IOException;

}
