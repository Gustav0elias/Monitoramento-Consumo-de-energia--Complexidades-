package br.edu.ifba.consumo.ordenador;

import java.util.List;

/**
 * Essa classe determina todas as ordenações que serão realizadas nesse programa,
 * A complexidade dele é constante O(1), Já que não possui loop. 
 * cuja complexidade, de forma geral, eh constante, O(1)
 */
public abstract class Ordenador<Sensor> {

    protected List<Sensor> leituras = null;

    public Ordenador(List<Sensor> leituras) {
        this.leituras = leituras;
    }

    public List<Sensor> getLeituras() {
        return this.leituras;
    }
    
    public abstract void ordenar();

}
