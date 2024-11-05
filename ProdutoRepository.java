package com.exemplo.padaria.repository;

import com.exemplo.padaria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

List<Produto> findByPrecoBetween(Double min, Double max);

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
