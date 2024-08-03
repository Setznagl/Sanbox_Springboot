package com.example.dependencyinjection_04.Pagamento;

import java.math.BigDecimal;

public interface GatewayPagamento {
    void EfetuarPagamento(String numeroCartao, BigDecimal valor);
}
