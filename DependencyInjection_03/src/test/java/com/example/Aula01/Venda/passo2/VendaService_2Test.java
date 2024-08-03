package com.example.Aula01.Venda.passo2;

import com.example.Aula01.Pagamento.passo2.MockService_INJ_DEP;
import com.example.Aula01.Venda.Venda;
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
        Ao invés de passar como parâmetro uma classe de pagamento passa a usar uma classe que implementa a interface,
        dessa forma não é preciso instanciar no construtor de venda a classe de pagamento, somente a interface de
        pagamento, isso garante que o código de venda não tenha de ser mudado (Princípio aberto fechado) e eu ainda
        tenho acesso a todos as classes de pagamento e métodos porque elas implementam a interface
    */

      //VendaService_INJ_DEP instanciaDoVendaService = new VendaService_INJ_DEP(new PagSeguroService_INJ_DEP("sasa"));
      //VendaService_INJ_DEP instanciaDoVendaService = new VendaService_INJ_DEP(new MercadoLivreService_INJ_DEP("8w9as"));
      VendaService_INJ_DEP instanciaDoVendaService = new VendaService_INJ_DEP(new MockService_INJ_DEP());

      //VendaService_INJ_DEP instanciaDoVendaService = new VendaService_INJ_DEP(new MercadoLivreService_INJ_DEP("8w8a33s2a6"));
      instanciaDoVendaService.registrarVenda( vendaTeste , "46569883625423");
    }
}