package org.example;

import java.util.Arrays;
import java.util.List;

public class Cliente implements ICliente {

    private Integer codigo;
    private String nome;
    private String cidade;
    private Float limiteCredito;
    private Float saldoDevedor;

    public Cliente(int codigo) {
        this.codigo = codigo;
        Cliente objeto = BD.getCliente(codigo);
        this.nome = objeto.nome;
        this.cidade = objeto.cidade;
        this.limiteCredito = objeto.limiteCredito;
        this.saldoDevedor = objeto.saldoDevedor;
    }

    public Cliente(Integer codigo, String nome, String cidade, Float limiteCredito, Float saldoDevedor) {
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
        this.limiteCredito = limiteCredito;
        this.saldoDevedor = saldoDevedor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nome, this.cidade);
    }

    @Override
    public List<Float> obterDadosFinanceiros(Funcionario funcionario) {
        return Arrays.asList(this.limiteCredito, this.saldoDevedor);
    }
}