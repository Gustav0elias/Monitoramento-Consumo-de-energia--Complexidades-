package br.edu.ifba.consumo.impl;

import java.text.DecimalFormat;

public class ConsumoEnergia {

    private Integer id = 0;
    private Double valor = 0.0; // Alterado para Double para representar o consumo em kWh
    private Residencia residencia; // Adicionamos uma referência à Residencia

    public ConsumoEnergia(Integer id, Double valor, Residencia residencia) {
        this.id = id;
        this.valor = valor;
        this.residencia = residencia;
    }

    public ConsumoEnergia(Double valor, Residencia residencia) {
        this.valor = valor;
        this.residencia = residencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

@Override
    public String toString() {
        // Crie um DecimalFormat para limitar o número de casas decimais
        DecimalFormat df = new DecimalFormat("#.##");

        // Formate o valor com duas casas decimais e inclua na string de saída
        return "Consumo de energia em kWh/h: " + df.format(valor) + " relacionado à " + residencia.getNome();
    }
}