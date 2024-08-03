package com.example.Aula01.Pagamento.passo2;

import java.math.BigDecimal;

public class PagSeguroService_INJ_DEP implements GatewayPagamento {
    private final String token;

    public PagSeguroService_INJ_DEP(String token) {
        this.token = token;
    }

    @Override
    public void EfetuarPagamento(String numeroCartao, BigDecimal valor) {
        System.out.println("Selecionado PagSeguro: ");
        boolean crashTest = true;
        if (crashTest) {
            System.out.println("[PagSeguro] Usando o token " + token);
            System.out.println("[PagSeguro] Cobrando " + valor + " do cartão " + numeroCartao+"\n");
            System.out.println("Código boilerplate de instância tratado\n");
        } else throw new RuntimeException("CrashTest derrubou o funcionamento do programa," +
                " mesmo com o a injeção de dependências o código não está resguardado contra" +
                " falhas na interface/abstração");
    }
}
