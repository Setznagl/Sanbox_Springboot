package com.example.Aula01.Venda.passo1;

import com.example.Aula01.Pagamento.passo1.PagSeguroService_2;

import java.math.BigDecimal;

public class MockPagSeguroService_2 extends PagSeguroService_2 {
    public MockPagSeguroService_2(String token) {
        super(token);
    }
    @Override
    public void EfetuarPagamento(String numeroCartao, BigDecimal valor) {
        System.out.println("[Mock] Selecionado Mock PagSeguro: ");
    }
}
