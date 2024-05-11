package list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
   private List<Tarefa> listaTarefas;

   public ListaTarefas(){
       listaTarefas = new ArrayList<>();
   }

   public void adionarTarefas(String desc){
       listaTarefas.add(new Tarefa(desc));
   }
   public void removerTarefas(String desc){
       if(listaTarefas.isEmpty()){
           System.out.println("a lista está vazia!!");
       }else{
            for(int i = 0; i < listaTarefas.size(); i++){
                if(listaTarefas.get(i).getDescricao().equalsIgnoreCase(desc)){
                    listaTarefas.remove(i);
                    System.out.println("ok");
                }
            }
       }
   }

   public int obterNumeroTotalTarefas(){
       return listaTarefas.size();
   }

   public List<String> obterDescricoesTarefas(){
       List<String> descricoes = new ArrayList<>();
       for(Tarefa tarefa : listaTarefas){
           descricoes.add(tarefa.getDescricao());
       }
       return descricoes;
   }
   

}
