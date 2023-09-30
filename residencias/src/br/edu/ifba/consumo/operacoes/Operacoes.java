package br.edu.ifba.consumo.operacoes;

import java.util.List;
import java.util.Map;

import br.edu.ifba.consumo.impl.ConsumoEnergia;
import br.edu.ifba.consumo.impl.Residencia;

/**
 * Interface que determina quais serão as operações realizadas no programa,
 * a complexidade e constante O(1), pois não existe nenhum loop nem nada do tipo.
 */

public interface Operacoes<Monitorado, Sensor> {
    

    // d.1
    public void imprimir(List<Monitorado> monitorados);

    // d.2
    public void imprimir(Map<Monitorado, List<Sensor>> leituras);

    // d.3
    public Map<Monitorado, List<Sensor>> ordenar(Map<Monitorado, List<Sensor>> leituras);

    // d.4
    public String calcularSomaConsumoEnergiaFormatado(Map<Residencia, List<ConsumoEnergia>> leituras, int periodo);
    
}
