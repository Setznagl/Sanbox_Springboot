package com.example.test;

import com.example.Aula01.Pagamento.MercadoLivreService_INJ_DEP;
import com.example.Aula01.Pagamento.MockService_INJ_DEP;
import com.example.Aula01.Pagamento.PagSeguroService_INJ_DEP;
import com.example.Aula01.Venda.Venda;
import com.example.Aula01.Venda.VendaService_INJ_DEP;
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
        Ao invés de vários construtores para instanciar as diversas variações de métodos de pagamento cria-se somente
        um construtor para uma interface (abstração em comum, todos são formas de pagamento) e cada uma das classes
        que antes possuia variações de construtor em VendaService agora implementam o construtor em comum de métodos de
        pagamento, isso garante que o código de venda não tenha de ser mudado (Princípio aberto fechado) e ainda
        tenho acesso a todas as classes de pagamento e métodos porque elas implementam uma interface em comum
    */

      //VendaService_INJ_DEP instanciaDoVendaService = new VendaService_INJ_DEP(new PagSeguroService_INJ_DEP("sasa"));
      VendaService_INJ_DEP instanciaDoVendaService = new VendaService_INJ_DEP(new MercadoLivreService_INJ_DEP("8w9as"));
      //VendaService_INJ_DEP instanciaDoVendaService = new VendaService_INJ_DEP(new MockService_INJ_DEP());

      //VendaService_INJ_DEP instanciaDoVendaService = new VendaService_INJ_DEP(new MercadoLivreService_INJ_DEP("8w8a33s2a6"));
      instanciaDoVendaService.registrarVenda( vendaTeste , "46569883625423");
    }
}