package com.digitalinovationone.gft.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.digitalinovationone.gft.model.Jedi;

@Repository
public class JediRepository {
	private List<Jedi> allJedi = null;
	
	@PostConstruct
	public void initialize() {
		allJedi = new ArrayList<>();
	}
	
	public List<Jedi> allJedi() {
		return allJedi;
	}

	public void add(Jedi jedi) {
		this.allJedi.add(jedi);
	}
}
