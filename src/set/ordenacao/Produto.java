package set.ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Produto implements Comparable<Produto>{
    private long cod;
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(long cod, String nome, int quantidade, double preco) {
        this.cod = cod;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    @Override
    public int compareTo(Produto o1){
        return this.nome.compareToIgnoreCase(o1.getNome());
    }
    public long getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return cod == produto.cod;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cod);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "cod=" + cod +
                ", nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}
class ComparaProdutoPorPreco implements Comparator<Produto> {

    @Override
    public int compare(Produto o1, Produto o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}
