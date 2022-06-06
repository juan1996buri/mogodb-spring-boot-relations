package com.nazeem.spring.mongo.api.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Book")
public class Book {
	@Id
	private String id;
	private String name;
	private String author;
	private Float price;
}
