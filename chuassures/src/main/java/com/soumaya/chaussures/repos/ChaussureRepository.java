package com.soumaya.chaussures.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soumaya.chaussures.entities.Chaussure;

public interface ChaussureRepository extends JpaRepository<Chaussure, Long> {

}
