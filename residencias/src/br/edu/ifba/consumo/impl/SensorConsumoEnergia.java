package br.edu.ifba.consumo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.ifba.consumo.sensor.Sensor;

/**
 * Gerador de leituras aleatórias de consumo de energia, cuja complexidade é linear,
 * O(N), pois inclui um loop/for que itera uma vez pelo total de leituras solicitadas.
 */


public class SensorConsumoEnergia implements Sensor<ConsumoEnergia> {

    private static final double CONSUMO_MEDIO = 152.2; 
    private static final double OSCILACAO_MAXIMA = 50.0; 

    private List<Residencia> residencias; 

    public SensorConsumoEnergia(List<Residencia> residencias) {
        this.residencias = residencias;
    }

    @Override
    public List<ConsumoEnergia> gerarLeituras(int totalLeituras) {
        List<ConsumoEnergia> leituras = new ArrayList<>();

        Random randomizador = new Random();
        for (int i = 0; i < totalLeituras; i++) {
            Residencia residenciaAleatoria = residencias.get(randomizador.nextInt(residencias.size()));
            double oscilacao = CONSUMO_MEDIO * randomizador.nextDouble() * (OSCILACAO_MAXIMA / 100.0);
            double consumo = (randomizador.nextBoolean() ? CONSUMO_MEDIO + oscilacao : CONSUMO_MEDIO - oscilacao);

            ConsumoEnergia leitura = new ConsumoEnergia(i + 1, consumo, residenciaAleatoria);
            leituras.add(leitura);
        }

        return leituras;
    }
}
