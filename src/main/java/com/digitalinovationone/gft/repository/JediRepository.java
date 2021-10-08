package com.digitalinovationone.gft.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.digitalinovationone.gft.model.Jedi;

@Repository
public interface JediRepository extends PagingAndSortingRepository<Jedi, Long> {
}
