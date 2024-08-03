package com.example.dependencyinjection_02;

import com.example.passo1.PagSeguroService_2;

public class MockPagSeguroService_2 extends PagSeguroService_2 {
    public MockPagSeguroService_2(String token) {
        super(token);
        System.out.println("[Mock] Selecionado Mock PagSeguro: ");
    }
}
