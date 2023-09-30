package br.edu.ifba.consumo.impl;

/**

 * Classe para simular uma residência.
 * Sua complexidade, de forma geral, é constante, O(1), visto  que não existe nenhum for ou outro tipo de loop..
 */


public class Residencia implements Comparable<Residencia> {

    private String id;
    private String nome;


    public Residencia(String id, String nome) {
        this.id = id;
        this.nome = nome;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "nome da residência: " + nome + ", id: " + id;
    }

    @Override
    public int compareTo(Residencia outraResidencia) {
        return this.getId().compareTo(outraResidencia.getId());
    }
}