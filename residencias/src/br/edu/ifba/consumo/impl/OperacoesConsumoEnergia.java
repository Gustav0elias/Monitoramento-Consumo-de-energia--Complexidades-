package br.edu.ifba.consumo.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.consumo.operacoes.Operacoes;
import br.edu.ifba.consumo.ordenador.Ordenador;

public class OperacoesConsumoEnergia implements Operacoes<Residencia, ConsumoEnergia> {

    /**
     * Imprime os dados de consumo de energia das residências.
     * A complexidade deste método é linear, O(N), porque o número de passos de execução
     * cresce linearmente de acordo ao total de residências
     */

    @Override
    public void imprimir(List<Residencia> monitorados) {
        for (Residencia residencia : monitorados) {
            System.out.println(residencia);
        }
    }

/**
 * Imprime os dados de consumo de energia por cada residência monitorada.
 * 
 * A complexidade deste método é quadrática, O(N^2), porque existem dois loops for aninhados,
 * aumentando o tempo de execução de maneira quadrática com base na quantidade de residências monitoradas.
 */


    @Override
    public void imprimir(Map<Residencia, List<ConsumoEnergia>> leituras) {
        for (Residencia residencia : leituras.keySet()) {
            System.out.println("leituras da residência " + residencia.getNome());
            for (ConsumoEnergia leitura : leituras.get(residencia)) {
                System.out.println(leitura);
            }
        }
    }


    /**
     * Realiza a ordenação das leituras de consumo de energia por cada residência monitorada.
     * 
     * A complexidade deste método é N^2logN, porque há um loop neste método que, internamente,
     * realiza uma chamada ao algoritmo de ordenação cuja complexidade é NlogN).
     */

    @Override
    public Map<Residencia, List<ConsumoEnergia>> ordenar(Map<Residencia, List<ConsumoEnergia>> leituras) {
        Map<Residencia, List<ConsumoEnergia>> leiturasOrdenadas = new TreeMap<>();

        for (Residencia residencia : leituras.keySet()) {
            System.out.println("ordenando as leituras da residência: " + residencia.getNome());

            List<ConsumoEnergia> leiturasParaOrdenar = leituras.get(residencia);
            Ordenador<ConsumoEnergia> ordenador = new OrdenadorConsumoEnergia(leiturasParaOrdenar);
            ordenador.ordenar();

            leiturasOrdenadas.put(residencia, leiturasParaOrdenar);
        }

        return leiturasOrdenadas;
    }


/**
 * Este método calcula a soma de consumo de energia para um período específico.
 * A complexidade cúbica (O(N^3)) se deve às três iterações aninhadas.
 *
 * Este método recebe um mapa contendo leituras de consumo de energia para várias residências.
 * O período especificado determina quantas leituras serão consideradas para cada residência.
 *
 */

public String calcularSomaConsumoEnergiaFormatado(Map<Residencia, List<ConsumoEnergia>> leituras, int periodo) {
    double somaTotal = 0.0;

    List<Residencia> residencias = new ArrayList<>(leituras.keySet());

    for (int i = 0; i < residencias.size(); i++) {
        for (int j = 0; j < residencias.size(); j++) {
            for (int k = 0; k < residencias.size(); k++) {
                Residencia residencia1 = residencias.get(i);
                Residencia residencia2 = residencias.get(j);
                Residencia residencia3 = residencias.get(k);

                List<ConsumoEnergia> leiturasResidencia1 = leituras.get(residencia1);
                List<ConsumoEnergia> leiturasResidencia2 = leituras.get(residencia2);
                List<ConsumoEnergia> leiturasResidencia3 = leituras.get(residencia3);

                if (periodo <= leiturasResidencia1.size() && periodo <= leiturasResidencia2.size() && periodo <= leiturasResidencia3.size()) {
                    for (int l = 0; l < periodo; l++) {
                        somaTotal += leiturasResidencia1.get(l).getValor();
                        somaTotal += leiturasResidencia2.get(l).getValor();
                        somaTotal += leiturasResidencia3.get(l).getValor();
                    }
                }
            }
        }
    }

    DecimalFormat df = new DecimalFormat("#.##");
    String resultadoFormatado = df.format(somaTotal);

    return "Soma de consumo de energia de três residências para um total de  " + periodo + " leituras: " + resultadoFormatado + " kw/h";
}
}