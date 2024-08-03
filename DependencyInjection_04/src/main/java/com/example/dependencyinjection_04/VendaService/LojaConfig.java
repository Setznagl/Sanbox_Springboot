package com.example.dependencyinjection_04.VendaService;


import com.example.dependencyinjection_04.Pagamento.MercadoLivreService_INJ_DEP;
import com.example.dependencyinjection_04.Pagamento.MockService_INJ_DEP;
import com.example.dependencyinjection_04.Pagamento.PagSeguroService_INJ_DEP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class LojaConfig {

    @Primary
    @Bean
    public PagSeguroService_INJ_DEP pagSeguroService() {
        return new PagSeguroService_INJ_DEP("A48aw6qwa3s2");
    }

    @Bean
    public MercadoLivreService_INJ_DEP mercadoLivreService() {
        return new MercadoLivreService_INJ_DEP("Me4ASA5S5AE");
    }

    @Bean
    public MockService_INJ_DEP mockService() {
        return new MockService_INJ_DEP();
    }

    /*
        Para instanciar um venda service irá procurar qual dos itens que implementam "gatewayPagamento" interface em comum
        possui a annotation @Primary e então criar uma instancia dessa dependência para que se ja possível instanciar a
        classe principal, que pode ser declarada também como um @Bean ou pela annotation @Component direto na classe

    //Exemplo como seria o Bean da classe principal, gatewayPagamento é a interface que todas as Beans implementam
    @Bean
    public VendaService_INJ_DEP vendaService(GatewayPagamento gatewayPagamento) {
        return new VendaService_INJ_DEP(gatewayPagamento);
    }
    */

}
