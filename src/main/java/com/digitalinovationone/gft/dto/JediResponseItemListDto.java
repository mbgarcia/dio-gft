package com.digitalinovationone.gft.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.RepresentationModel;

import com.digitalinovationone.gft.model.Jedi;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JediResponseItemListDto extends RepresentationModel<JediResponseItemListDto> {
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String lastName;
	
	public JediResponseItemListDto(Jedi jedi) {
		BeanUtils.copyProperties(jedi, this);
	}
}
