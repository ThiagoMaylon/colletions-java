package map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> palavrasSet;

    public ContagemPalavras(){
        this.palavrasSet = new HashMap<>();
    }

    public void adicionarPalavras(String palavra, Integer contagem){
        palavrasSet.put(palavra, contagem);
    }
    public void removerPalavra(String palavra){
        if(palavrasSet.containsKey(palavra)){
            palavrasSet.remove(palavra);
        }else{
            System.out.println("palavra não encontrada");
        }
    }
    public int exibirContagemPalavras(){
        return palavrasSet.size();
    }
    public String encontrarPalavraMaisFrequente(){
        String maisFrequente = null;
        Integer frequencia = 0;
        if(!palavrasSet.isEmpty()){
            for(Map.Entry<String, Integer> entry : palavrasSet.entrySet()){
                if(entry.getValue() > frequencia){
                    frequencia = entry.getValue();
                    maisFrequente = entry.getKey();
                }
            }
            return maisFrequente;
        }else{
            throw new RuntimeException("o map está vazio");
        }
    }
    public static void main(String[] args){
        ContagemPalavras contagemLinguagens = new ContagemPalavras();

        // Adiciona linguagens e suas contagens
        contagemLinguagens.adicionarPalavras("Java", 2);
        contagemLinguagens.adicionarPalavras("Python", 8);
        contagemLinguagens.adicionarPalavras("JavaScript", 1);
        contagemLinguagens.adicionarPalavras("C#", 6);

        // Exibe a contagem total de linguagens
        System.out.println("Existem " + contagemLinguagens.exibirContagemPalavras() + " palavras.");

        // Encontra e exibe a linguagem mais frequente
        String linguagemMaisFrequente = contagemLinguagens.encontrarPalavraMaisFrequente();
        System.out.println("A linguagem mais frequente é: " + linguagemMaisFrequente);
    }
}
