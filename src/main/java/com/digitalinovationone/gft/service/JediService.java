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
import com.digitalinovationone.gft.dto.JediResponseItemListDto;
import com.digitalinovationone.gft.exception.BusinessException;
import com.digitalinovationone.gft.hateoas.LinkDetalheJedi;
import com.digitalinovationone.gft.model.Jedi;
import com.digitalinovationone.gft.repository.JediRepository;

@Service
public class JediService {
	@Autowired
	private JediRepository repository;
	
	public List<JediResponseItemListDto> getAll() throws BusinessException {
		Iterable<Jedi> lista = repository.findAll();
		
		List<JediResponseItemListDto> dtos = new ArrayList<>();
		
		for (Jedi jedi: lista) {
			JediResponseItemListDto dto = new JediResponseItemListDto(jedi);
			dto.add(new LinkDetalheJedi(dto).build());
			
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
	
	public Jedi findById(Long id) throws BusinessException {
		Optional<Jedi> opt = repository.findById(id);
		
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new BusinessException("error.notfound.jedi", new Object[] {id});
		}
	}
	
	public JediDto findOneById(Long id) throws BusinessException {
		Jedi jedi = findById(id);
		JediDto dto = new JediDto();
		BeanUtils.copyProperties(jedi, dto);
		
		return dto;
	}

	@Transactional
	public void update(Long id, @Valid JediDto dto) throws BusinessException {
		Jedi jedi = this.findById(id);
		BeanUtils.copyProperties(dto, jedi);
		
		repository.save(jedi);
	}

	@Transactional
	public void delete(Long id) throws BusinessException {
		Jedi jedi = this.findById(id);
		
		repository.delete(jedi);
	}
}
