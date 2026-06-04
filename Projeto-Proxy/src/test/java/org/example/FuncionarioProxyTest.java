package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioProxyTest {

    @BeforeEach
    void setUp() {
        BD.addFuncionario(new Funcionario(1, "Gustavo", "Juiz de Fora", 500.0f, 1000.0f));
        BD.addFuncionario(new Funcionario(2, "Lucas", "Rio de Janeiro", 300.0f, 700.0f));
    }

    @Test
    void deveRetornarDadosPessoaisFuncionario() {
        FuncionarioProxy funcionario = new FuncionarioProxy(1);

        assertEquals(Arrays.asList("Gustavo", "Juiz de Fora"), funcionario.obterDadosPessoais());
    }

    @Test
    void deveRetonarBeneficiosFuncionario() {
        Gerente gerente = new Gerente("Vítor", true);
        FuncionarioProxy funcionario = new FuncionarioProxy(2);

        assertEquals(Arrays.asList(300.0f, 700.0f), funcionario.obterBeneficios(gerente));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarBeneficiosFuncionario() {
        try {
            Gerente gerente = new Gerente("Felipe", false);
            FuncionarioProxy funcionario = new FuncionarioProxy(2);

            funcionario.obterBeneficios(gerente);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Gerente não autorizado!", e.getMessage());
        }
    }
}