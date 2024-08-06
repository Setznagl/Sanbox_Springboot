package com.example.multipledatasources;

import com.example.multipledatasources.primeiroBanco.Model.Pessoa;
import com.example.multipledatasources.primeiroBanco.Repository.PessoaRepository;
import com.example.multipledatasources.segundoBanco.Model.Produto;
import com.example.multipledatasources.segundoBanco.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultipleDataSourcesApplication implements CommandLineRunner {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public static void main(String[] args) {
        SpringApplication.run(MultipleDataSourcesApplication.class, args);}


    public void run(){
        pessoaRepository.save(new Pessoa(1L,"Joao"));
        produtoRepository.save(new Produto(1L,"Notebook Lenovo T14 V2"));
    }

    @Override
    public void run(String... args) throws Exception {
        pessoaRepository.save(new Pessoa(1L,"Joao"));
        produtoRepository.save(new Produto(1L,"Notebook Lenovo T14 V2"));
    }
}
