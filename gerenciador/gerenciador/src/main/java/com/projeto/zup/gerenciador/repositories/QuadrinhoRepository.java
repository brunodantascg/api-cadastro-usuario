package com.projeto.zup.gerenciador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.zup.gerenciador.models.Quadrinho;

@Repository
public interface QuadrinhoRepository extends JpaRepository<Quadrinho, Integer> {

}

