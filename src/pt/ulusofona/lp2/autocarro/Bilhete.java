package pt.ulusofona.lp2.autocarro;

public class Bilhete {

    int numero;

    public Bilhete(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "" + numero;
    }
}
