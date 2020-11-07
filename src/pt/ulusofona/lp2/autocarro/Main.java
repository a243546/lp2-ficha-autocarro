package pt.ulusofona.lp2.autocarro;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Autocarro a1 = new Autocarro(3);

        a1.adicionarParagem(new Paragem("Benfica"));
        a1.adicionarParagem(new Paragem("Sete Rios"));

        System.out.println("--> " + a1);

        Pessoa p1 = new Pessoa("Maria");

        a1.entrar(p1);

        System.out.println("--> " + p1);
        p1.setBilhete(new Bilhete(42));
        System.out.println("--> " + p1);

        System.out.println(autocarroSuburbano());
        System.out.println(autocarroUrbano());


    }

    public static Autocarro autocarroUrbano() {
        Autocarro autocarro = new Autocarro(30);

        autocarro.adicionarParagem(new Paragem("Rossio"));
        autocarro.adicionarParagem(new Paragem("Entrecampos"));
        autocarro.adicionarParagem(new Paragem("Campo Grande"));

        return autocarro;
    }

    public static Autocarro autocarroSuburbano() {
        Autocarro autocarro = new Autocarro((27));

        ArrayList<Paragem> percurso = new ArrayList<>();

        percurso.add(new Paragem("Rossio"));
        percurso.add(new Paragem("Entrecampos"));
        percurso.add(new Paragem("Campo Grande"));
        percurso.add(new Paragem("Benfica"));

        autocarro.setPercurso(percurso);

        return autocarro;
    }

    public static ArrayList<Autocarro> doisAutocarros() {
        ArrayList<Autocarro> autocarros = new ArrayList<>();

        autocarros.add(autocarroUrbano());
        autocarros.add(autocarroSuburbano());

        return autocarros;
    }

    static  HashMap<Integer, Autocarro> autocarrosPorID() {
        HashMap<Integer, Autocarro> result  =  new HashMap<>();

        result.put(100, autocarroUrbano());
        result.put(200, autocarroSuburbano());

        return result;
    }

}
