package com.cg.bankapp.query.entites;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Cutomer_Query")
public class Customer {
	
	@Id
	private int id;

	@Column(unique = true)
    private String uid;3
	
	private String firstName , lastName,username ,password;
	
	
}