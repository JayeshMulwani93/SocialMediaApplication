package com.jayesh93.solutions.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.jayesh93.solutions.model.Post;

@Service
public class PostProducerServiceImpl implements PostProducerService {

	@Value("${posts.topic}")
	private String topic;

	@Autowired
	private KafkaTemplate<String, Post> kafkaTemplate;

	@Override
	public void send(Post post) {
		kafkaTemplate.send(topic, post);
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
}