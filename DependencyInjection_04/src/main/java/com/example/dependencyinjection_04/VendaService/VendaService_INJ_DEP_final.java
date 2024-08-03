package com.example.dependencyinjection_04.VendaService;


import com.example.dependencyinjection_04.Pagamento.GatewayPagamento;
import com.example.dependencyinjection_04.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class VendaService_INJ_DEP_final {

     /*
        public VendaService_INJ_DEP(GatewayPagamento Parametro) {
            this.variavelInstancia = Parametro;
        }
     */

    GatewayPagamento variavelInstancia;


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
    @Autowired
    public void setGatewayPagamento(GatewayPagamento variavelInstancia) {
        this.variavelInstancia = variavelInstancia;
    }
}

