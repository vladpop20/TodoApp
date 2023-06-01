package com.coodru.todolist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
	@NotNull(message = "Invalid title: Title is NULL")
	@Size(min = 3, max = 200, message = "Invalid title: Must be of 3 - 200 characters")
	private String title;

	@NotBlank(message = "Description must not be empty")
	@NotNull(message = "Invalid description: desc is NULL")
	@Size(min = 3, message = "Invalid description: Must be of minimum 3 characters")
	private String description;

	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dueDate;

	@NotBlank(message = "The status is mandatory")
	@NotNull(message = "Invalid status: status is NULL")
	@Pattern(regexp = "^(To Do|In Progress|Done)$", message = "Invalid status type")
	private String status;
}
