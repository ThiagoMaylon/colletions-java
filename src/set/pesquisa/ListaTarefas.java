package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas(){
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao));
    }
    public void removerTarefa(String descricao){
        Tarefa tarefaRemover = null;
        if(!tarefaSet.isEmpty()){
            for(Tarefa tarefa : tarefaSet){
                if(tarefa.getDescricao().equals(descricao)){
                    tarefaRemover = tarefa;
                }
            }
            tarefaSet.remove(tarefaRemover);
        }else{
            throw new RuntimeException("a lista está vazia");
        }
    }
    public void exibirTarefas(){
        if(!tarefaSet.isEmpty()){
            for(Tarefa tarefa : tarefaSet){
                System.out.println(tarefa);
            }
        }else{
            System.out.println("a lista está vazia");
        }
    }

    public int contarTarefas(){
        return tarefaSet.size();
    }
    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> concluidas = new HashSet<>();
        if(!tarefaSet.isEmpty()){
            for(Tarefa tarefa : tarefaSet){
                if(tarefa.isConcluido()){
                    concluidas.add(tarefa);
                }
            }

            return concluidas;
        }else{
            throw new RuntimeException("a lista está vazia");
        }
    }
    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> pendentes = new HashSet<>();
        if(!tarefaSet.isEmpty()){
            for(Tarefa tarefa : tarefaSet){
                if(!tarefa.isConcluido()){
                    pendentes.add(tarefa);
                }
            }

            return pendentes;
        }else{
            throw new RuntimeException("a lista está vazia");
        }
    }
    public void marcarTarefaConcluida(String descricao){
        if(!tarefaSet.contains(descricao)){
            for(Tarefa tarefa : tarefaSet){
                if(tarefa.getDescricao().equals(descricao)){
                    tarefa.setConcluido(true);
                }
            }
        }else{
            System.out.println("tarefa não encontrada");
        }
    }
    public void marcarTarefaPendente(String descricao){
        if(!tarefaSet.contains(descricao)){
            for(Tarefa tarefa : tarefaSet){
                if(tarefa.getDescricao().equals(descricao)){
                    tarefa.setConcluido(false);
                }
            }
        }else{
            System.out.println("tarefa não encontrada");
        }
    }
    public void limparListaTarefas(){
        tarefaSet.clear();
    }

    public static void main(String[] args){
        // Criando uma instância da classe ListaTarefas
        ListaTarefas listaTarefas = new ListaTarefas();

        // Adicionando tarefas à lista
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercícios físicos");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Preparar apresentação");

        // Exibindo as tarefas na lista
        listaTarefas.exibirTarefas();

        // Removendo uma tarefa
        listaTarefas.removerTarefa("Fazer exercícios físicos");
        listaTarefas.exibirTarefas();

        // Contando o número de tarefas na lista
        System.out.println("Total de tarefas na lista: " + listaTarefas.contarTarefas());

        // Obtendo tarefas pendentes
        System.out.println(listaTarefas.obterTarefasPendentes());

        // Marcando tarefas como concluídas
        listaTarefas.marcarTarefaConcluida("Ler livro");
        listaTarefas.marcarTarefaConcluida("Estudar Java");

        // Obtendo tarefas concluídas
        System.out.println(listaTarefas.obterTarefasConcluidas());

        // Marcando tarefas como pendentes
        listaTarefas.marcarTarefaPendente("Estudar Java");
        listaTarefas.exibirTarefas();

        // Limpando a lista de tarefas
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}
