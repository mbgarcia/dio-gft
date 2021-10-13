package com.digitalinovationone.gft.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.Link;

import com.digitalinovationone.gft.controller.JediRestController;
import com.digitalinovationone.gft.dto.JediResponseItemListDto;
import com.digitalinovationone.gft.exception.BusinessException;

public class LinkDetalheJedi {
	private JediResponseItemListDto dto;
	
	public LinkDetalheJedi(JediResponseItemListDto dto) {
		this.dto = dto;
	}

	public Link build() throws BusinessException {
		return linkTo(methodOn(JediRestController.class).getOneJedi(dto.getId())).withSelfRel();
	}
}
