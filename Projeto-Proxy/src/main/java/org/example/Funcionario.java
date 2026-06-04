package org.example;

import java.util.Arrays;
import java.util.List;

public class Funcionario implements IFuncionario{

    private Integer id;
    private String nome;
    private String cidade;
    private Float planoDeSaude;
    private Float valeAlimentacao;

    public Funcionario(int id) {
        this.id = id;
        Funcionario objeto = BD.getFuncionario(id);
        this.nome = objeto.nome;
        this.cidade = objeto.cidade;
        this.planoDeSaude = objeto.planoDeSaude;
        this.valeAlimentacao = objeto.valeAlimentacao;
    }

    public Funcionario(Integer id, String nome, String cidade, Float planoDeSaude, Float valeAlimentacao) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.planoDeSaude = planoDeSaude;
        this.valeAlimentacao = valeAlimentacao;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.cidade);
    }

    @Override
    public List<Float> obterBeneficios(Gerente gerente) {
        return Arrays.asList(this.planoDeSaude, this.valeAlimentacao);
    }
}
