package com.example.Aula01.Pagamento.passo1;

import java.math.BigDecimal;

public class MercadoLivreService_2 {
    private final String token;

    public MercadoLivreService_2(String token) {
        this.token = token;
    }

    public void EfetuarPagamento(String numeroCartao, BigDecimal valor) {
        System.out.println("Selecionado MercadoLivre: ");
        boolean crashTest = true;
        if (crashTest) {
            System.out.println("[PagSeguro] Usando o token " + token);
            System.out.println("[PagSeguro] Cobrando " + valor + " do cartão " + numeroCartao+"\n");
            System.out.println("Código boilerplate de instância tratado\n");
            System.out.println("Plugabilidade, somente o construtor é alterado, evita que" +
                    "todos os parâmetros de instâncias locais devam ser tratados em caso de mudança\n");
        } else throw new RuntimeException("CrashTest derrubou o funcionamento do programa," +
                " mesmo com o a injeção de dependências o código não está resguardado contra" +
                " falhas na interface/abstração");
    }
}
