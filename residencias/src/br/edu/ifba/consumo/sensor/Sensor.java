package br.edu.ifba.consumo.sensor;

/**
 * Interface que determina a funcionalidade do sensor, que no caso vai gerar leituras,.
 * A complexidade é constante O(1), visto que não existe loop.
 */

import java.util.List;

public interface Sensor<ConsumoEnergia> {
    
    public List<ConsumoEnergia> gerarLeituras(int totalLeituras);

}
