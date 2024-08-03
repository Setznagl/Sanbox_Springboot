package com.example;

import com.example.passo1.PagSeguroService_2;

import java.math.BigDecimal;

public class VendaService_2 {
     /*
        Tratado instanciação dentro da classe, agora é tarefa do construtor receber uma instancia e armazena-la em uma
        variável local
     */

    public VendaService_2(PagSeguroService_2 PagSeguroServiceParametro) {
        this.variavelInstancia = PagSeguroServiceParametro;
    }PagSeguroService_2 variavelInstancia;
    /*
    public VendaService_INJ_DEP(MercadoLivreService_INJ_DEP mercadoLivreServiceInjDep){
        this.variavelInstancia = mercadoLivreServiceInjDep;
    }MercadoLivreService_INJ_DEP variavelInstancia;
     */

    public void registrarVenda(Venda vendaParametro, String numeroCartao) {
        BigDecimal valorTotal = vendaParametro.getPrecoUnitario()
                .multiply(new BigDecimal(vendaParametro.getQuantidade()));

        System.out.println("[venda] registrado venda de " + vendaParametro.getProduto()
                + " no valor de " + valorTotal);
        /*
        Não é mais instanciado porque deve vir dentro do construtor e armazenada em uma instancia local
        SUBSTITUIDO INSTANCIA DURANTE A EXECUÇÃO POR PARÂMETRO NO CONSTRUTOR
        //PagSeguroService_INJ_DEP instanciaPagSeguroService = new PagSeguroService_INJ_DEP("889a9sa5sa6s5a6s22x5a6ss");
        */

        variavelInstancia.EfetuarPagamento(numeroCartao, valorTotal);
    }
}

