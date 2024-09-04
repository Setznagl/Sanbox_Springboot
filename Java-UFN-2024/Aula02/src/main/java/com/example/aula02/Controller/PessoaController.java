package com.example.aula02.Controller;

import com.example.aula02.Model.Pessoa;
import com.example.aula02.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> getPessoas() {
        return pessoaRepository.findAll();
    }

    @PostMapping
    public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Autowired
    public void setRepository(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }
}
