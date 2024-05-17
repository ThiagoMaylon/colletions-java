package list.ordenacao;

import java.util.Comparator;

public class Pessoa implements Comparable<Pessoa>{
    private String nome;
    private int idade;
    private double altura;

    public Pessoa(String nome, int idade, double altura){
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }
    @Override
    public int compareTo(Pessoa pessoa){
        if(this.idade < pessoa.getIdade()){
            return -1;
        }
        if(this.idade > pessoa.getIdade()){
            return 1;
        }
        return 0;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                '}';
    }
}

class CompararAltura implements Comparator<Pessoa>{
    @Override
    public int compare(Pessoa pessoa1, Pessoa pessoa2){
        if(pessoa1.getAltura() > pessoa2.getAltura()){
            return 1;
        }
        if(pessoa1.getAltura() < pessoa2.getAltura()){
            return -1;
        }
        return 0;
    }
}
