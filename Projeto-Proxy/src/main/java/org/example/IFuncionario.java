package org.example;

import java.util.List;

public interface IFuncionario {

    List<String> obterDadosPessoais();
    List<Float> obterBeneficios(Gerente gerente);
}
