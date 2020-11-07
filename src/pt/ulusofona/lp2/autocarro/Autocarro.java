package pt.ulusofona.lp2.autocarro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Autocarro {

    int capacidade;
    ArrayList<Paragem> percurso;
    ArrayList<Pessoa> passageiros;

    public Autocarro(int capacidade) {
        this.capacidade = capacidade;
        this.percurso = new ArrayList<>();
        this.passageiros = new ArrayList<>();
    }

    @Override
    public String toString() {
        String passageirosStr = passageiros == null || passageiros.size() == 0 ? "vazio" : "" + passageiros.size();
        String percursoStr = percurso == null || percurso.size() == 0 ? "s/ percurso" : percurso.stream().map(Paragem::toString).collect(Collectors.joining(" » "));

        return capacidade + " | " + passageirosStr + " | " + percursoStr;
    }

    public void setPercurso(ArrayList<Paragem> percurso) {
        this.percurso = percurso;
    }

    public void adicionarParagem(Paragem paragem) {
        if (percurso == null) {
            percurso = new ArrayList<>();
        }

        percurso.add(percurso.size(), paragem);
    }

    public String imprimirPercurso() {
        return percurso == null || percurso.size() == 0 ? "" : percurso.stream().map(Paragem::toString).collect(Collectors.joining(" » "));
    }

    public boolean entrar(Pessoa pessoa) {
        if (!pessoa.temBilhete()) {
            return false;
        }

        if (passageiros.size() < capacidade) {
            passageiros.add(pessoa);
            return true;
        } else {
            return false;
        }
    }

    public boolean passaNaParagem(String nomeParagem) {
        for (Paragem p : percurso) {
            if (p.temNome(nomeParagem)) {
                return true;
            }
        }

        return false;
    }

    public boolean sair(Pessoa pessoa) {
        if (passageiros.contains(pessoa)) {
            passageiros.remove(pessoa);
            return true;
        }

        return false;
    }

    public void registarCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean mesmoPercurso(Autocarro outro) {
        if (this.percurso == null || this.percurso.isEmpty() || outro.percurso == null || outro.percurso.isEmpty()) {
            return false;
        }

        if (this.percurso.size() != outro.percurso.size()) {
            return false;
        }

        for (int i = 0; i < this.percurso.size(); i++) {
            if (!this.percurso.get(i).nome.equals(outro.percurso.get(i).nome)) {
                return false;
            }
        }

        return true;
    }

    boolean temLigacao(Autocarro outro) {
        if (this.percurso == null || this.percurso.isEmpty() || outro.percurso == null || outro.percurso.isEmpty()) {
            return false;
        }

        return this.percurso.get(this.percurso.size() - 1).nome.equals(outro.percurso.get(0).nome);
    }

    boolean temParagensComuns(Autocarro outro) {
        if (this.percurso == null || this.percurso.isEmpty() || outro.percurso == null || outro.percurso.isEmpty()) {
            return false;
        }

        for (Paragem p1 : this.percurso) {
            for (Paragem p2 : outro.percurso) {
                if (p1.nome.equals(p2.nome)) {
                    return true;
                }
            }
        }

        return false;
    }

    HashSet<Paragem> paragensComuns(Autocarro outro) {
        HashSet<Paragem> result = new HashSet<>();

        if (!(this.percurso == null || this.percurso.isEmpty() || outro.percurso == null || outro.percurso.isEmpty())) {
            for (Paragem p1 : this.percurso) {
                for (Paragem p2 : outro.percurso) {
                    if (p1.nome.equals(p2.nome)) {
                        result.add(p1);
                    }
                }
            }

        }

        return result;
    }

}
