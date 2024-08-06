package com.example.aula04.Controller;

import com.example.aula04.Model.Pessoa;
import com.example.aula04.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//Request mapping na classe indica que as sucessoras aglutinarão o caminho com o caminho pai da classe
@RequestMapping(path = "/pessoa")
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @RequestMapping("/cadastrar")
    public String cadastrarPessoa(Model model) {
        model.addAttribute("pessoa_attribute", new Pessoa());
        //Envia para a view cadastrar pessoa
        return "cadastrarPessoa";
    }

    @GetMapping(path = "/listar")
    public String listarPessoas(@ModelAttribute Pessoa pessoa, Model model) {
        return recuperarListaPessoas(model);
    }

    @GetMapping("/alterar/{id}")
    public String alterarPessoa(@PathVariable Long id, Model model) {
        //Optional não dispara exceção se o objeto com o id iterado não existir
        Optional<Pessoa> p = pessoaRepository.findById(Math.toIntExact(id));
        model.addAttribute("pessoa_attribute", p.get());
        return "alterarPessoa";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPessoa(@PathVariable Long id, Model model) {
        //Optional não dispara exceção se o objeto com o id iterado não existir
        Optional<Pessoa> p = pessoaRepository.findById(Math.toIntExact(id));
        pessoaRepository.delete(p.get());

        return recuperarListaPessoas(model);
    }

    @PostMapping("/alterar")
    public String alterarPessoa(@ModelAttribute Pessoa pessoaAttribute_alterada, Model model) {
        //Recebe via post da view alterarPessoa
        pessoaRepository.save(pessoaAttribute_alterada);
        return recuperarListaPessoas(model);
    }

    @PostMapping("/save")
    public String salvarPessoa(@ModelAttribute Pessoa pessoa_attribute, Model model) {
        /*
        Equivalente ao getAttribute e setAttribute, @RequestMapping manda o atributo pessoa_attribute da classe
        pessoa, nesse caso vazio, que será preenchido no formulário e captado pelo @ModelAttribute

        model carrega atributos antes de renderizar a página
        */

        //Recebe via post da view cadastrarPessoa
        pessoaRepository.save(pessoa_attribute);
        return recuperarListaPessoas(model);
    }

    //Reduzindo repetição sobre todas as vezes que a lista é recarregada após uma operação
    public String recuperarListaPessoas(Model model) {
        List<Pessoa> listaOnDatabase = (List<Pessoa>) pessoaRepository.findAll();
        model.addAttribute("listaPessoa_attribute", listaOnDatabase);
        return "listarPessoas";
    }
}





