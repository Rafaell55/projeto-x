package com.rafael.projetox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.projetox.domain.CategoriaTeve;;

@Repository
public interface CategoriaTeveRepository extends JpaRepository<CategoriaTeve, Integer>{
	
	

}
