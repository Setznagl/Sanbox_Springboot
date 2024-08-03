package com.example.dependencyinjection_02;

import com.example.Venda;
import com.example.VendaService_2;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class VendaService_2Test {

    @Test
    void registrarVenda() {
        Venda vendaTeste = new Venda();
        vendaTeste.setProduto("Headset Razer");
        vendaTeste.setQuantidade(1);
        vendaTeste.setPrecoUnitario(new BigDecimal("139.5"));

      /*
        Não é mais instanciado o PagSeguroService localmente porque deve vir dentro do construtor e armazenada  em uma
        instancia local, oque previne quebra após o início e durante a execução do código por erros na classe secundária

        NÃO É POSSÍVEL INSTANCIAR O VendaService SEM FORNECER O PARÂMETRO

        Plugabilidade, como as instâncias são definidas no construtor é mais fácil de adaptar o código;
      */

      //Chamando o Mock para não executar nenhum método
      VendaService_2 instanciaDoVendaService = new VendaService_2(new MockPagSeguroService_2("s4ea3s3"));
      //VendaService_INJ_DEP instanciaDoVendaService = new VendaService_INJ_DEP(new PagSeguroService_INJ_DEP("sa4s4a55w7a5as1"));
      //VendaService_INJ_DEP instanciaDoVendaService = new VendaService_INJ_DEP(new MercadoLivreService_INJ_DEP("8w8a33s2a6"));

      instanciaDoVendaService.registrarVenda( vendaTeste , "46569883625423");
    }
}