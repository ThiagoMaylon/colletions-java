package map.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private  Map<String, String> dicionarioMap;

    public Dicionario(){
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao){
        dicionarioMap.put(palavra, definicao);
    }
    public void removerPalavra(String palavra){
        if(dicionarioMap.containsKey(palavra)){
            dicionarioMap.remove(palavra);
        }else{
            System.out.println("palavra não encontrada");
        }
    }

    public void exibirPalavras(){
        System.out.println(dicionarioMap);
    }
    public String pesquisarPorPalavra(String palavra){
        if(dicionarioMap.containsKey(palavra)){
            return dicionarioMap.get(palavra);
        }else{
            throw new RuntimeException("palavra não encontrada");
        }
    }

    public static void main(String[] args){
        Dicionario dicionario = new Dicionario();

        // Adicionar palavras (linguagens de programação)
        dicionario.adicionarPalavra("java", "Linguagem de programação orientada a objetos.");
        dicionario.adicionarPalavra("typescript", "Superset da linguagem JavaScript que adiciona tipagem estática.");
        dicionario.adicionarPalavra("kotlin", "Linguagem moderna de programação para a JVM.");

        // Exibir todas as palavras
        dicionario.exibirPalavras();

        // Remover uma palavra
        dicionario.removerPalavra("typescript");
        dicionario.exibirPalavras();
        
        // Pesquisar palavras
        String definicaoJava = dicionario.pesquisarPorPalavra("java");
        System.out.println("Definição da linguagem 'java': " + definicaoJava);

        String definicaoCSharp = dicionario.pesquisarPorPalavra("csharp");
        System.out.println(definicaoCSharp);


    }
}
