package com.example.Aula01.Pagamento;

import java.math.BigDecimal;

public class PagSeguroService {
    private final String token;

    public PagSeguroService(String token) {
        this.token = token;
    }

    public void EfetuarPagamento(String numeroCartao , BigDecimal valor , Boolean dependencyTest){
        if (dependencyTest) {
            System.out.println("[PagSeguro] Usando o token " + token);
            System.out.println("[PagSeguro] Cobrando " + valor + " do cartão " + numeroCartao);
        }else {
            throw new RuntimeException("Classe acoplada quebra o funcionamento do código principal");
        }
    }
}
