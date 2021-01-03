package com.jayesh93.solutions.model;

import java.util.List;

import lombok.Data;

@Data
public class Response<T> {

	private List<T> data;

}
