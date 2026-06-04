package org.example;

import java.util.List;

public class FuncionarioProxy implements IFuncionario{

    private Funcionario funcionario;

    private Integer id;

    public FuncionarioProxy(Integer id) {
        this.id = id;
    }

    @Override
    public List<String> obterDadosPessoais() {
        if (this.funcionario == null) {
            this.funcionario = new Funcionario(this.id);
        }
        return this.funcionario.obterDadosPessoais();
    }

    @Override
    public List<Float> obterBeneficios(Gerente gerente) {
        if (!gerente.isAdministrador()) {
            throw new IllegalArgumentException("Gerente não autorizado!");
        }
        if (this.funcionario == null) {
            this.funcionario = new Funcionario(this.id);
        }
        return this.funcionario.obterBeneficios(gerente);
    }
}
