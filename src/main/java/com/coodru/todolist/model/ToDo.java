package com.coodru.todolist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dueDate;

	@NotBlank(message = "The status is mandatory")
	@Pattern(regexp = "^(To Do|In Progress|Done)$", message = "Invalid status type")
	private String status;
}
