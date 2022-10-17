package ouvidoria;

import java.util.ArrayList;

public class Manifestacao {
    private int numero;
    private String nome;
    private String descricao;
    private String modelo;
    private ArrayList<Manifestacao> manifestacoes = new ArrayList<>();

    public Manifestacao() {

    }

    public void novaManifestacao(Manifestacao m) {
        manifestacoes.add(m);
    }

    public Manifestacao(int numero, String nome, String descricao, String modelo) {
        this.numero = numero;
        this.nome = nome;
        this.descricao = descricao;
        this.modelo = modelo;
    }

    public ArrayList<Manifestacao> getManifestacoes() {
        return manifestacoes;
    }

    public int getNumero() {
        return numero;
    }

    public String getModelo() {
        return modelo;
    }


    public Manifestacao getManifestacaoPorNumero(int numero) {
        for (Manifestacao conta : manifestacoes) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return  numero +
                "\nRequisitante: " + nome  +
                "\nModelo: " + modelo +
                "\nDescricao: " + descricao + "\n";
    }
}
