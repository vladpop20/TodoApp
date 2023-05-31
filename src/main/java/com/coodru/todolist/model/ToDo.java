package com.coodru.todolist.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table
@Data
public class ToDo {

	@Id
	@SequenceGenerator(name = "todo_sequence", sequenceName = "seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_sequence")
	private Long id;

	@NotBlank(message = "Title must not be empty")
	private String title;

	@NotBlank(message = "Description must not be empty")
	private String description;

	@NotBlank(message = "Date until expiration must not be empty")
	private LocalDate dueDate;

	@NotBlank(message = "The status is mandatory")
	@Pattern(regexp = "^(To Do|In Progress|Done)$", message = "Invalid status type")
	private String status;
}
