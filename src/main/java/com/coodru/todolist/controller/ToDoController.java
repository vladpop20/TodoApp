package com.coodru.todolist.controller;

import com.coodru.todolist.model.ToDo;
import com.coodru.todolist.service.spec.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/todo")
public class ToDoController {

	private final ToDoService toDoService;

	@GetMapping
	public List<ToDo> getToDoList(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "15") int limit) {

		return toDoService.getToDoList(page, limit);
	}

	@GetMapping(path = "/{id}")
	public ToDo getToDo(@PathVariable Long id) {
		return toDoService.getToDo(id);
	}

	@PostMapping
	public ToDo createToDo(@RequestBody @Valid ToDo todoDetails) {
		return toDoService.createToDo(todoDetails);
	}

	@PutMapping("/{id}")
	public ToDo updateToDo(@PathVariable Long id, @RequestBody @Valid ToDo toDoDetails) {
		return toDoService.updateToDo(toDoDetails, id);
	}

	@DeleteMapping("/{id}")
	public void deleteToDo(@PathVariable Long id) {
		toDoService.deleteToDo(id);
	}
}
