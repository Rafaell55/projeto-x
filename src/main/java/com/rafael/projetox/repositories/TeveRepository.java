package com.rafael.projetox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.projetox.domain.Teve;

@Repository
public interface TeveRepository extends JpaRepository<Teve, Integer>{
	
	

}
