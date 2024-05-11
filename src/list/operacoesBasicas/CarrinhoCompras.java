package list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    private List<Itens> listaItens;

    public CarrinhoCompras(){
        listaItens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        listaItens.add(new Itens(nome, quantidade, preco));
    }
    public void removeItem(String nome){
        if(!listaItens.isEmpty()){
            for(int i = 0; i < listaItens.size(); i++){
                if(listaItens.get(i).getNome().equalsIgnoreCase(nome)){
                    listaItens.remove(i);
                }
            }
        }else{
            System.out.println("o Carrinho está vazio!!");
        }
    }

    public double calculaValorTotal(){
        double total = 0;
        if(!listaItens.isEmpty()){
            for(Itens item : listaItens){
                total += item.getPreco() * item.getQuantidade();
            }
        }else{
            System.out.println("o Carrinho está vazio!!");
        }
        return total;
    }

    public void exibirItens(){
        if(!listaItens.isEmpty()){
            for(Itens item : listaItens){
                System.out.printf("Nome: %s | Preço: %,.2f | Quantidade: %d\n", item.getNome(), item.getPreco(), item.getQuantidade());
            }
        }else{
            System.out.println("o Carrinho está vazio!!");
        }
    }
}
