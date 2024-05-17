package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos(){
        this.contatoSet = new HashSet<>();
    }
    public void adicionarContato(String nome, int numero){
        contatoSet.add(new Contato(nome, numero));
    }
    public void exibirContatos(){
        if(!contatoSet.isEmpty()){
            for(Contato contato : contatoSet){
                System.out.println(contato);
            }
        }else{
            System.out.println("a agenda está vazia");
        }
    }
    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatos = new HashSet<>();
        if(!contatoSet.isEmpty()){
            for(Contato contato : contatoSet){
                if(contato.getNome().startsWith(nome)){
                    contatos.add(contato);
                }
            }
            return contatos;
        }else{
            throw new RuntimeException("o contato está vazio");
        }
    }
    public Contato atualizarNumeroContato(String nome, int novoNumero){
        Contato contatoAtualizado = null;
        if(!contatoSet.isEmpty()){
            for(Contato contato : contatoSet){
                if(contato.getNome().equals(nome)){
                    contato.setNumero(novoNumero);
                    contatoAtualizado = contato;
                }
            }
            return contatoAtualizado;
        }else{
            throw new RuntimeException("a agenda está vazia");
        }
    }
    public static void main(String[] args){
        // Criando uma instância da classe AgendaContatos
        AgendaContatos agendaContatos = new AgendaContatos();

        // Exibindo os contatos no conjunto (deve estar vazio)
        agendaContatos.exibirContatos();

        // Adicionando contatos à agenda
        agendaContatos.adicionarContato("João", 123456789);
        agendaContatos.adicionarContato("Maria", 987654321);
        agendaContatos.adicionarContato("Maria Fernandes", 55555555);
        agendaContatos.adicionarContato("Ana", 88889999);
        agendaContatos.adicionarContato("Fernando", 77778888);
        agendaContatos.adicionarContato("Carolina", 55555555);

        // Exibindo os contatos na agenda
        agendaContatos.exibirContatos();

        // Pesquisando contatos pelo nome
        System.out.println(agendaContatos.pesquisarPorNome("Maria"));

        // Atualizando o número de um contato
        Contato contatoAtualizado = agendaContatos.atualizarNumeroContato("Carolina", 44443333);
        System.out.println("Contato atualizado: " + contatoAtualizado);

        // Exibindo os contatos atualizados na agenda
        System.out.println("Contatos na agenda após atualização:");
        agendaContatos.exibirContatos();
    }
}
