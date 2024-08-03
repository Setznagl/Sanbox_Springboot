package com.example.Aula01.Venda.inicio;

import com.example.Aula01.Venda.Venda;
import com.example.Aula01.Venda.VendaService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class VendaServiceTest {
    @Test
    void registrarVenda() {
        Venda vendaTeste = new Venda();
        vendaTeste.setProduto("Headset Razer");
        vendaTeste.setQuantidade(1);
        vendaTeste.setPrecoUnitario(new BigDecimal("139.5"));

        /*
          Classe de alto nível fortemente dependente (Fortemente Acoplado)
          de classe de baixo nível fere princípios SOLID, deve ser dependente apenas de abstrações

          Se houver qualquer problema com a classe acoplada nesse caso PagSeguroService
          dentro de VendaService os testes quebram
        */

        /*
          Parâmetro "DependencyTest" é um boolean que funciona como interruptor para evidenciar
          a quebra do código no teste se a classe acoplada for comprometida
         */

        VendaService instanciaVendaService = new VendaService();
        instanciaVendaService.registrarVenda( vendaTeste , "46569883625423");
    }
}