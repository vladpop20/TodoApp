package com.coodru.todolist.exceptions;

import java.io.Serial;

public class ToDoNotFoundException extends RuntimeException {
	@Serial
	private static final long serialVersionUID = 1708696283730274736L;

	public ToDoNotFoundException(String message) {
		super(message);
	}
}
