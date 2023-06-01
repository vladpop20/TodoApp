package com.coodru.todolist.service.spec;

import com.coodru.todolist.model.ToDo;

import java.util.List;

public interface ToDoService {

	ToDo createToDo(ToDo toDo);

	List<ToDo> getToDoList(int page, int limit);

	ToDo getToDo (Long toDoId);

	ToDo updateToDo(ToDo todo, Long toDoId);

	void deleteToDo(Long toDoId);
}
