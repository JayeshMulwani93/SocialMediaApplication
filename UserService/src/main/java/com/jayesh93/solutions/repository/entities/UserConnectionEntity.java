package com.jayesh93.solutions.repository.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_CONNECTION")
public class UserConnectionEntity {

	@EmbeddedId
	private UserConnectionId id;

}