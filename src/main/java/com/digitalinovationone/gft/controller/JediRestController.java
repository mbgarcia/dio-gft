package com.digitalinovationone.gft.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinovationone.gft.dto.JediDto;
import com.digitalinovationone.gft.exception.BusinessException;
import com.digitalinovationone.gft.service.JediService;

@RestController
@RequestMapping("/api/jedi")
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
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createJedi(@Valid @RequestBody JediDto dto) throws BusinessException {
		service.add(dto);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateJedi(@PathVariable("id") Long id, @Valid @RequestBody JediDto dto) throws BusinessException {
		service.update(id, dto);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteJedi(@PathVariable("id") Long id) throws BusinessException {
		service.delete(id);
	}	
	
}
