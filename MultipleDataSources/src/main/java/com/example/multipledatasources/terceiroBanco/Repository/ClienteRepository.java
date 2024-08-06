package com.example.multipledatasources.terceiroBanco.Repository;

import com.example.multipledatasources.terceiroBanco.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
