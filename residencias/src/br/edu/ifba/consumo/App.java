package br.edu.ifba.consumo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.consumo.impl.ConsumoEnergia;
import br.edu.ifba.consumo.impl.OperacoesConsumoEnergia;
import br.edu.ifba.consumo.impl.Residencia;
import br.edu.ifba.consumo.impl.SensorConsumoEnergia;
import br.edu.ifba.consumo.operacoes.Operacoes;
import br.edu.ifba.consumo.sensor.Sensor;

public class App {

    private static final int TOTAL_DE_RESIDENCIAS = 10;
    private static final int TOTAL_DE_LEITURAS = 1000;

    /*
    Complexidade linear, O(N), devido à uma iteração sobre a lista de residências, onde N representa o número total de residências na simulação.
     
     */
    public static void main(String[] args) throws Exception {
        Operacoes<Residencia, ConsumoEnergia> operacoes = new OperacoesConsumoEnergia();
        
  
        List<Residencia> residencias = new ArrayList<>();
        for (int i = 0; i < TOTAL_DE_RESIDENCIAS; i++) {
            String id = (i + 1) + "";
            residencias.add(new Residencia(id, "Residência #" + id));
        }


        Sensor<ConsumoEnergia> sensor = new SensorConsumoEnergia(residencias);

        Map<Residencia, List<ConsumoEnergia>> leiturasPorResidencia = new TreeMap<>();
        for (int i = 0; i < TOTAL_DE_RESIDENCIAS; i++) {
            String id = (i + 1) + "";
            leiturasPorResidencia.put(new Residencia(id, "Residência #" + id), 
                sensor.gerarLeituras(TOTAL_DE_LEITURAS)
            );
        }

        // (d.1) imprimir a lista das pessoas ou dos objetos sendo monitorados;
        operacoes.imprimir(new ArrayList<Residencia>(leiturasPorResidencia.keySet()));

        // (d.2) imprimir a lista das leituras por cada pessoa ou objeto monitorado.
        operacoes.imprimir(leiturasPorResidencia);

        // (d.3) ordenação crescente dos dados considerando os valores lidos dos sensores para cada coisa monitorada;
        Map<Residencia, List<ConsumoEnergia>> leiturasOrdenadas = operacoes.ordenar(leiturasPorResidencia);
        operacoes.imprimir(leiturasOrdenadas);

        //(d.4) deve ser adicionada, a critério do desenvolvedor, uma funcionalidade extra, relativa ao mini-mundo escolhido, cuja complexidade seja ou O(N^3) ou O(2^N) ou O(N!).
        String resultadoFormatado = operacoes.calcularSomaConsumoEnergiaFormatado(leiturasPorResidencia, 10);

        System.out.println(resultadoFormatado);

    }
}

