package com.example.Aula01.Venda.passo2;

import com.example.Aula01.Pagamento.passo2.GatewayPagamento;
import com.example.Aula01.Venda.Venda;

import java.math.BigDecimal;

public class VendaService_INJ_DEP {

    public VendaService_INJ_DEP(GatewayPagamento Parametro) {
        this.variavelInstancia = Parametro;
    }GatewayPagamento variavelInstancia;


    public void registrarVenda(Venda vendaParametro, String numeroCartao) {
        BigDecimal valorTotal = vendaParametro.getPrecoUnitario()
                .multiply(new BigDecimal(vendaParametro.getQuantidade()));

        System.out.println("[venda] registrado venda de " + vendaParametro.getProduto()
                + " no valor de " + valorTotal);
        /*
            Não depende mais de nenhuma alteração nos construtores dentro de venda service, visto que ele não
            depende mais das classes acopladas, apenas da interface implementada
        */

        variavelInstancia.EfetuarPagamento(numeroCartao, valorTotal);
    }
}

