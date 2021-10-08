package com.digitalinovationone.gft.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinovationone.gft.dto.JediDto;
import com.digitalinovationone.gft.exception.BusinessException;
import com.digitalinovationone.gft.model.Jedi;
import com.digitalinovationone.gft.repository.JediRepository;

@Service
public class JediService {
	@Autowired
	private JediRepository repository;
	
	public List<JediDto> getAll() {
		Iterable<Jedi> lista = repository.findAll();
		
		List<JediDto> dtos = new ArrayList<>();
		
		for (Jedi jedi: lista) {
			JediDto dto = new JediDto();
			BeanUtils.copyProperties(jedi, dto);
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Transactional
	public void add(@Valid JediDto dto) {
		Jedi jedi = new Jedi();
		BeanUtils.copyProperties(dto, jedi);
		repository.save(jedi);
	}
	
	
	public JediDto findOneById(Long id) throws BusinessException {
		Optional<Jedi> opt = repository.findById(id);
		
		if (opt.isPresent()) {
			JediDto dto = new JediDto();
			BeanUtils.copyProperties(opt.get(), dto);
			return dto;
		} else {
			throw new BusinessException("error.notfound.jedi", new Object[] {id});
		}
	}
}
