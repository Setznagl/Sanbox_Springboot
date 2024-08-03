package com.example.Aula01.Pagamento.passo2;

import java.math.BigDecimal;

public class MockService_INJ_DEP implements GatewayPagamento{
    @Override
    public void EfetuarPagamento(String numeroCartao, BigDecimal valor) {
        System.out.println("[Mock] Gateway mock acessado");
    }
}
