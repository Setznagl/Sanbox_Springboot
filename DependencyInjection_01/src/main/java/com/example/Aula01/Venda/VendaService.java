package com.example.Aula01.Venda;

import com.example.Aula01.Pagamento.PagSeguroService;

import java.math.BigDecimal;

public class VendaService {
    public VendaService(){}

    public void registrarVenda(Venda vendaParametro, String numeroCartao){
        BigDecimal valorTotal = vendaParametro.getPrecoUnitario()
                .multiply(new BigDecimal(vendaParametro.getQuantidade()));

        System.out.println("[venda] registrado venda de " + vendaParametro.getProduto()
                + " no valor de " + valorTotal);
        System.out.println("[Sistema] Chegou até a classe VendaService\n");

        //Instanciação local, toda vez que os parâmetros são alterados todas as instâncias locais precisam ser alteradas
        PagSeguroService instanciaPagSeguroService = new PagSeguroService("889a9sa5sa6s5a6s22x5a6ss");
        //Deslique esta variável e o teste de toda a classe falhará
        Boolean dependencyTest = true;
        instanciaPagSeguroService.EfetuarPagamento(numeroCartao, valorTotal , dependencyTest);
    }
}

