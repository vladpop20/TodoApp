package com.coodru.todolist.controller;

import com.coodru.todolist.exceptions.ToDoNotFoundException;
import com.coodru.todolist.model.ToDo;
import com.coodru.todolist.service.spec.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/todo")
public class ToDoController {

	private final ToDoService toDoService;

	@GetMapping
	public ResponseEntity<?> getToDoList(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "15") int limit) {
		return new ResponseEntity<>(toDoService.getToDoList(page, limit), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getToDo(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(toDoService.getToDo(id), HttpStatus.OK);
		} catch (ToDoNotFoundException e) {
			return new ResponseEntity<>(String.format("Todo with ID: %s not found", id), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> createToDo(@RequestBody @Valid ToDo todoDetails) {
		return new ResponseEntity<>(toDoService.createToDo(todoDetails), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateToDo(@PathVariable Long id, @RequestBody @Valid ToDo toDoDetails) {
		try {
			return new ResponseEntity<>(toDoService.updateToDo(toDoDetails, id), HttpStatus.OK);
		} catch (ToDoNotFoundException e) {
			return new ResponseEntity<>(String.format("Todo with ID: %s not found", id), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteToDo(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(String.format("Todo with ID: %s was deleted successfully", id), HttpStatus.OK);
		} catch (ToDoNotFoundException e) {
			return new ResponseEntity<>(String.format("Todo with ID: %s not found", id), HttpStatus.NOT_FOUND);
		}
	}
}
