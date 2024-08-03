package com.example.Aula01.Pagamento.passo2;

import java.math.BigDecimal;

public interface GatewayPagamento {
    void EfetuarPagamento(String numeroCartao, BigDecimal valor);
}
