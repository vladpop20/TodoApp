package com.coodru.todolist.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum ErrorMessages {
	MISSING_REQUIRED_FIELD("Missing required field. Please check documentation for required fields"),
	RECORD_ALREADY_EXISTS("ToDo already exists"),
	INTERNAL_SERVER_ERROR("Internal server error"),
	NO_RECORD_FOUND("ToDo with provided Id is not found"),
	COULD_NOT_UPDATE_RECORD("Could not update ToDo"),
	COULD_NOT_DELETE_RECORD("Could not delete ToDo");

	@Getter
	@Setter
	private String errorMessage;
}
