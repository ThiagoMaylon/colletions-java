package list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    List<Integer> listaNumeros;

    public OrdenacaoNumeros(){
        listaNumeros = new ArrayList<>();
    }
    public void adicionarNumero(int numero){
        listaNumeros.add(numero);
    }
    public List<Integer> ordenarAscendente(){
        List<Integer> listaOrdenada = new ArrayList<>(listaNumeros);
        if(!listaOrdenada.isEmpty()){
            Collections.sort(listaOrdenada);
            return  listaOrdenada;
        }else{
            throw new RuntimeException("a lista está vazia");
        }
    }public List<Integer> ordenarDescendente(){
        List<Integer> listaOrdenada = new ArrayList<>(listaNumeros);
        if(!listaOrdenada.isEmpty()){
            listaOrdenada.sort(Collections.reverseOrder());
            return  listaOrdenada;
        }else{
            throw new RuntimeException("a lista está vazia");
        }
    }
    public static void main(String[] args){
        OrdenacaoNumeros numeros = new OrdenacaoNumeros();
        numeros.adicionarNumero(2);
        numeros.adicionarNumero(5);
        numeros.adicionarNumero(4);
        numeros.adicionarNumero(1);
        numeros.adicionarNumero(99);

        System.out.println(numeros.ordenarAscendente());
        System.out.println(numeros.ordenarDescendente());
    }
}
