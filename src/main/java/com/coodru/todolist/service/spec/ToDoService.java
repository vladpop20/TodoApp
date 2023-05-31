package com.coodru.todolist.service.spec;

import com.coodru.todolist.model.ToDo;

import java.util.List;

public interface ToDoService {

	ToDo createToDo(ToDo toDo);

	List<ToDo> getToDoList();

	ToDo getToDo (Long id);

	ToDo updateToDo(ToDo todo, Long id);
}
