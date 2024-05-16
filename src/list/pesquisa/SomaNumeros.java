package list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> listaNumeros;

    public SomaNumeros(){
        listaNumeros = new ArrayList<>();
    }
    public void adicionaNumero(int numero){
        this.listaNumeros.add(numero);
    }
    public int calcularSoma(){
        int soma = 0;
        for(int numero : listaNumeros){
            soma+= numero;
        }
        return soma;
    }
    public int encontrarMaiorNumero(){
        int maior = 0;
        for(Integer numero : listaNumeros){
            if(numero > maior){
                maior = numero;
            }
        }
        return maior;
    }
    public int encontrarMenorNumero(){
        int menor = listaNumeros.get(0);
        for(Integer numero : listaNumeros){
            if(numero < menor){
                menor = numero;
            }
        }
        return menor;
    }
    public List<Integer> exibirNumeros(){
        return listaNumeros;
    }

}
