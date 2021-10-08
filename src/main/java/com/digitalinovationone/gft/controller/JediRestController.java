package com.digitalinovationone.gft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinovationone.gft.dto.JediDto;
import com.digitalinovationone.gft.exception.BusinessException;
import com.digitalinovationone.gft.service.JediService;

@RestController
@RequestMapping("/api")
public class JediRestController extends BaseRestController {
	@Autowired
	JediService service;
	
	@GetMapping("/all")
	public List<JediDto> allJedi() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public JediDto getOneJedi(@PathVariable Long id) throws BusinessException {
		return service.findOneById(id);
	}
}
