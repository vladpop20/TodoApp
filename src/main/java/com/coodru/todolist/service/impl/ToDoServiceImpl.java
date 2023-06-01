package com.coodru.todolist.service.impl;

import com.coodru.todolist.exceptions.ToDoNotFoundException;
import com.coodru.todolist.model.ToDo;
import com.coodru.todolist.repository.ToDoRepository;
import com.coodru.todolist.service.spec.ToDoService;
import com.coodru.todolist.shared.ErrorMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {

	private final ToDoRepository repository;

	@Override
	public ToDo createToDo(ToDo toDo) {
		return repository.save(toDo);
	}

	@Override
	public List<ToDo> getToDoList(int page, int limit) {
		Pageable pageableRequest = PageRequest.of(page, limit);
		Page<ToDo> toDoPage = repository.findAll(pageableRequest);
		return toDoPage.getContent();
	}

	@Override
	public ToDo getToDo(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ToDoNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
	}

	@Override
	public ToDo updateToDo(ToDo todo, Long id) {
		return repository.findById(id)
				.map(foundTodo -> {
					foundTodo.setTitle(todo.getTitle());
					foundTodo.setDescription(todo.getDescription());
					foundTodo.setDueDate(todo.getDueDate());
					foundTodo.setStatus(todo.getStatus());
					repository.save(foundTodo);
					return foundTodo;
				})
				.orElseThrow(() -> new ToDoNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage()));
	}

	@Override
	public void deleteToDo(Long toDoId) {
		repository.delete(repository.findById(toDoId)
				.orElseThrow(() -> new ToDoNotFoundException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage())));
	}
}
