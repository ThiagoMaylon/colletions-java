package map.ordenacao;

public class Livro implements Comparable<Livro>{
    private String autor, titulo;
    private double preco;

    public Livro(String titulo, String autor, double preco) {
        this.autor = autor;
        this.titulo = titulo;
        this.preco = preco;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", preco=" + preco +
                '}';
    }

    @Override
    public int compareTo(Livro o) {
        return Double.compare(this.getPreco(), o.getPreco());
    }
}
