package com.tpro.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@NoArgsConstructor
public class Book {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@JsonProperty("bookName") // JSON çıktıda isminin "bookName" olmasını sağladık
	private String name;
	
	@JsonIgnore // sonsuz döngüye girmemesi için , kısaca buradan yeniden student 
	// clasına gitememesi için bu anotation'ı kullandık
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Student getStudent() {
		return student;
	}

	
	
	

}
