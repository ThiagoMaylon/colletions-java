package map.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> contatoMap;

    public AgendaContatos(){
        contatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        contatoMap.put(nome, telefone);
    }

    public void removerContato(String nome){
        if(contatoMap.containsKey(nome)){
            contatoMap.remove(nome);
        }else{
            System.out.println("contato não encontrado");
        }
    }

    public void exibirContatos(){
        if(!contatoMap.isEmpty()){
            System.out.println(contatoMap);
        }else{
            throw new RuntimeException("o map está vazio");
        }
    }

    public Integer pesquisarPorNome(String nome){
        if(contatoMap.containsKey(nome)){
            return contatoMap.get(nome);
        }else{
            throw new RuntimeException("contato não encontrado");
        }
    }

    public static void main(String[] args){
        AgendaContatos agendaContatos = new AgendaContatos();

        // Adicionar contatos
        agendaContatos.adicionarContato("Camila", 123456);
        agendaContatos.adicionarContato("João", 5665);
        agendaContatos.adicionarContato("Carlos", 1111111);
        agendaContatos.adicionarContato("Ana", 654987);
        agendaContatos.adicionarContato("Maria", 1111111);
        agendaContatos.adicionarContato("Camila", 44444);

        agendaContatos.exibirContatos();

        // Remover um contato
        agendaContatos.removerContato("Maria");
        agendaContatos.exibirContatos();

        // Pesquisar número por nome
        String nomePesquisa = "João";
        Integer numeroPesquisa = agendaContatos.pesquisarPorNome("João");
        System.out.println("Número de telefone de " + nomePesquisa + ": " + numeroPesquisa);

        String nomePesquisaNaoExistente = "Paula";
        Integer numeroPesquisaNaoExistente = agendaContatos.pesquisarPorNome(nomePesquisaNaoExistente);
        System.out.println("Número de telefone de " + nomePesquisaNaoExistente + ": " + numeroPesquisaNaoExistente);
    }
}
