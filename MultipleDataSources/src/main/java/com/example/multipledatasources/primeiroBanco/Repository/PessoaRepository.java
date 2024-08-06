package com.example.multipledatasources.primeiroBanco.Repository;

import com.example.multipledatasources.primeiroBanco.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
