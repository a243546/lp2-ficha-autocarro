package pt.ulusofona.lp2.autocarro;

public class Pessoa {

    String nome;
    Bilhete bilhete;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome + " - " + (bilhete == null ? "s/ bilhete" : bilhete);
    }

    public void setBilhete(Bilhete bilhete) {
        this.bilhete = bilhete;
    }

    public boolean temBilhete() {
        return bilhete != null;
    }

}
