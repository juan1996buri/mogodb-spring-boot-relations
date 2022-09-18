package com.nazeem.spring.mongo.api.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Ciudad")
public class Ciudad {
	@Id
	private String id;
	private String nombre;
	private Provincia provincia;
}
