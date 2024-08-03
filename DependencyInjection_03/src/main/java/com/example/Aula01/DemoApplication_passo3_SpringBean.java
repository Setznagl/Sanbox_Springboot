package com.example.Aula01;

import com.example.Aula01.Venda.Venda;
import com.example.Aula01.Venda.passo2.VendaService_INJ_DEP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class DemoApplication_passo3_SpringBean {

    public static void main(String[] args) {
        /*
            Container de inversão de controle do Spring em si, é possível armazenar em variável para ter
            acesso aos Beans declarados
        */
         ApplicationContext SpringContainer = SpringApplication.run(DemoApplication_passo3_SpringBean.class, args);

        //Instanciando o VendaService através do Bean
        VendaService_INJ_DEP instanciaDoVendaService = SpringContainer.getBean(VendaService_INJ_DEP.class);

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
