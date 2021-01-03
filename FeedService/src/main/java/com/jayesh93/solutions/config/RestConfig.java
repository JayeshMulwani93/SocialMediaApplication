package com.jayesh93.solutions.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@RefreshScope
public class RestConfig {

	@Value("${connection.timeout}")
	public int timeOut;

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(timeOut);
		return new RestTemplate(requestFactory);
	}

//	@Bean
//	public ObjectMapper getObjectMapper() {
//		SimpleModule module = new SimpleModule();
//		module.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer());
//
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.registerModule(module);
//		return mapper;
//	}
}
