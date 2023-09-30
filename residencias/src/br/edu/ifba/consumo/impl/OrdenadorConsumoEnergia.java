package br.edu.ifba.consumo.impl;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.consumo.ordenador.Ordenador;

/**
 * 
 * O algoritmo utilizado é uma adaptação do algoritmo de ordenação Merge Sort.
 * A complexidade é de O(NLogN), pois o algoritmo divide a coleção de dados a ser ordenada
 * e, em seguida, combina cada subcoleção de dados para realizar a ordenação.
 */

public class OrdenadorConsumoEnergia extends Ordenador<ConsumoEnergia> {
    
  
    public OrdenadorConsumoEnergia(List<ConsumoEnergia> leituras) {
        super(leituras);
    }

    public void ordenar() {
        ordenar(0, leituras.size() - 1);
    }

    public void ordenar(int inicio, int fim) {
        if (inicio < fim && (fim - inicio) >= 1) {
            int meio = (fim + inicio) / 2;

            ordenar(inicio, meio);
            ordenar(meio + 1, fim);

            ordenar(inicio, meio, fim);
        }
    }

    private void ordenar(int inicio, int meio, int fim) {
        List<ConsumoEnergia> leiturasTemp = new ArrayList<>();

        int esquerda = inicio;
        int direita = meio + 1;

        while (esquerda <= meio && direita <= fim) {
            if (leituras.get(esquerda).getValor() <= leituras.get(direita).getValor()) {
                leiturasTemp.add(leituras.get(esquerda));
                esquerda++;
            } else {
                leiturasTemp.add(leituras.get(direita));
                direita++;
            }
        }

        while (esquerda <= meio) {
            leiturasTemp.add(leituras.get(esquerda));
            esquerda++;
        }

        while (direita <= fim) {
            leiturasTemp.add(leituras.get(direita));
            direita++;
        }

        for (int i = 0; i < leiturasTemp.size(); inicio++) {
            leituras.set(inicio, leiturasTemp.get(i++));
        }
    }
    }

