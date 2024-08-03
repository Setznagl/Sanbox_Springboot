package com.example.dependencyinjection_04;

import com.example.dependencyinjection_04.VendaService.VendaService_INJ_DEP_final;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class DependencyInjection04Application {

    public static void main(String[] args) {
        /*
            Container de inversão de controle do Spring em si, é possível armazenar em variável para ter
            acesso aos Beans declarados
        */
        ApplicationContext SpringContainer = SpringApplication.run(DependencyInjection04Application.class);

        //Instanciando o VendaService através do Bean
        VendaService_INJ_DEP_final instanciaDoVendaService = SpringContainer.getBean(VendaService_INJ_DEP_final.class);

        //Instanciando um objeto da Model comum Venda
        Venda vendaTeste = new Venda();
        vendaTeste.setProduto("Headset Razer");
        vendaTeste.setQuantidade(1);
        vendaTeste.setPrecoUnitario(new BigDecimal("139.5"));

        /*
            Registrando a venda, obs, caso mais um de um gateway ser configurado prevalecerá o com a annotation @Primary,
            que buscará o bean do tipo GatewayPagamento prioritário para instancia-lo e assim instanciar vendaService
         */

        instanciaDoVendaService.registrarVenda( vendaTeste , "46569883625423");
    }

}
