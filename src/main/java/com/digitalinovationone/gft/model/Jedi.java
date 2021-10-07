package com.digitalinovationone.gft.model;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Jedi {
	@NotBlank
	private String name;
	
	@NotBlank
	private String lastName;

	public Jedi(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
}
