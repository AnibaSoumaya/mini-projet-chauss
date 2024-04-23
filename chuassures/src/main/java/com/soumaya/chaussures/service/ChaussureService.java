package com.soumaya.chaussures.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.soumaya.chaussures.entities.Chaussure;

public interface ChaussureService {

	Chaussure saveChaussure(Chaussure c);
	Chaussure updateChaussure(Chaussure c);
	void deleteChaussure(Chaussure c);
	void deleteChaussureById(Long id);
	Chaussure getChaussure(Long id);
	List<Chaussure> getAllChaussures();
	
	Page<Chaussure> getAllChaussuresParPage(int page, int size);
}