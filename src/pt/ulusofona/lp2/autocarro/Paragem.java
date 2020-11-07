package pt.ulusofona.lp2.autocarro;

public class Paragem {

    String nome;

    public Paragem(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    boolean temNome(String nome) {
        return this.nome.equals(nome);
    }

}
