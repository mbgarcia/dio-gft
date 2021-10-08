package com.digitalinovationone.gft.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JediDto {
	@NotBlank
	private String name;
	
	@NotBlank
	private String lastName;

}
