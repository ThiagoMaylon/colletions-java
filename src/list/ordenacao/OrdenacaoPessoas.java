package list.ordenacao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas{
    public List<Pessoa> listaPessoa;
    public OrdenacaoPessoas(){
        listaPessoa = new ArrayList<>();
    }

    public void adicionaPessoa(String nome, int idade, double altura){
        listaPessoa.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade(){
        List<Pessoa> listaOrdenada = new ArrayList<>(listaPessoa);
        if(!listaOrdenada.isEmpty()){
            Collections.sort(listaOrdenada);
            return listaOrdenada;
        }else{
            throw new RuntimeException("a lista está vazia");
        }
    }
    public List<Pessoa> ordenarPorAltura(){
        List<Pessoa> listaOrdenada = new ArrayList<>(listaPessoa);
        CompararAltura compararAltura = new CompararAltura();

        if(!listaOrdenada.isEmpty()){
            Collections.sort(listaOrdenada, compararAltura);
            return listaOrdenada;
        }else{
            throw new RuntimeException("a lista está vazia");
        }
    }

    public static void main(String[] args){
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

        // Adicionando pessoas à lista
        ordenacaoPessoas.adicionaPessoa("Alice", 28, 1.56);
        ordenacaoPessoas.adicionaPessoa("Bob", 20, 1.80);
        ordenacaoPessoas.adicionaPessoa("Charlie", 25, 1.70);
        ordenacaoPessoas.adicionaPessoa("David", 17, 1.56);
        System.out.println(ordenacaoPessoas.ordenarPorIdade());
        System.out.println(ordenacaoPessoas.ordenarPorAltura());

    }

}
