package com.example.Aula01.Pagamento.passo1;

import java.math.BigDecimal;

public class PagSeguroService_2 {
    private final String token;

    public PagSeguroService_2(String token) {
        this.token = token;
    }

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
