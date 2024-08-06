package com.example.multipledatasources.segundoBanco.Repository;

import com.example.multipledatasources.segundoBanco.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
