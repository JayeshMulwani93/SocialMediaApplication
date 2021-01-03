package com.jayesh93.solutions.messaging;

import com.jayesh93.solutions.model.Post;

public interface PostProducerService {

	void send(Post post);

}
