package map.ordenacao;

import java.time.LocalDate;

public class Evento implements Comparable<Evento>{
    private LocalDate data;
    private String nome, atracao;

    public Evento(LocalDate data, String nome, String atracao) {
        this.data = data;
        this.nome = nome;
        this.atracao = atracao;
    }
    public Evento() {}

    public LocalDate getData() {
        return data;
    }

    public String getNome() {
        return nome;
    }

    public String getAtracao() {
        return atracao;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "data=" + data +
                ", nome='" + nome + '\'' +
                ", atracao='" + atracao + '\'' +
                '}';
    }

    @Override
    public int compareTo(Evento o) {
        return this.data.compareTo(o.getData());
    }
}
