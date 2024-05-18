package map.pesquisa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstoqueProdutos {
    Map<Long, Produto> produtoMap;

    public EstoqueProdutos(){
        this.produtoMap = new HashMap<>();
    }
    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        produtoMap.put(cod, new Produto(nome, quantidade, preco));
    }
    public void exibirProdutos(){
        System.out.println(this.produtoMap);
    }
    public double calcularValorTotalEstoque(){
        double total = 0d;
        if(!produtoMap.isEmpty()){
            for(Produto produto : produtoMap.values()){
                total += produto.getPreco() * produto.getQuantidade();
            }
            return total;
        }else{
            throw new RuntimeException("estoque está vazio");
        }

    }

    public Produto obterProdutoMaisCaro(){
        List<Produto> produtos = new ArrayList<>();
        if(!produtoMap.isEmpty()){
            for(Produto produto : produtoMap.values()){
                produtos.add(produto);
            }
            Produto produtoMaisCaro = produtos.getFirst();
            for(Produto produto : produtos){
                if(produto.getPreco() > produtoMaisCaro.getPreco()){
                    produtoMaisCaro = produto;
                }
            }
            return produtoMaisCaro;
        }else{
            throw new RuntimeException("estoque está vazio");
        }
    }
    public Produto obterProdutoMaisBarato(){
        List<Produto> produtos = new ArrayList<>();
        if(!produtoMap.isEmpty()){
            for(Produto produto : produtoMap.values()){
                produtos.add(produto);
            }
            Produto produtoMaisBarato = produtos.getFirst();
            for(Produto produto : produtos){
                if(produto.getPreco() < produtoMaisBarato.getPreco()){
                    produtoMaisBarato = produto;
                }
            }
            return produtoMaisBarato;
        }else{
            throw new RuntimeException("estoque está vazio");
        }
    }
    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        List<Produto> produtos = new ArrayList<>();
        if(!produtoMap.isEmpty()){
            for(Produto produto : produtoMap.values()){
                produtos.add(produto);
            }
            Produto produtoTotalMaisCaro = produtos.getFirst();
            for(Produto produto : produtos){
                if(produto.getPreco() * produto.getQuantidade() > produtoTotalMaisCaro.getPreco() * produtoTotalMaisCaro.getQuantidade()){
                    produtoTotalMaisCaro = produto;
                }
            }
            return produtoTotalMaisCaro;
        }else{
            throw new RuntimeException("estoque está vazio");
        }
    }
    public static void main(String[] args){
        EstoqueProdutos estoque = new EstoqueProdutos();

        // Exibe o estoque vazio
        estoque.exibirProdutos();

        // Adiciona produtos ao estoque
        estoque.adicionarProduto(1L, "Notebook", 1, 1500.0);
        estoque.adicionarProduto(2L, "Mouse", 5, 25.0);
        estoque.adicionarProduto(3L, "Monitor", 10, 400.0);
        estoque.adicionarProduto(4L, "Teclado", 2, 40.0);

        // Exibe os produtos no estoque
        estoque.exibirProdutos();

        // Calcula e exibe o valor total do estoque
        System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());

        // Obtém e exibe o produto mais caro
        Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
        System.out.println("Produto mais caro: " + produtoMaisCaro);

        // Obtém e exibe o produto mais barato
        Produto produtoMaisBarato = estoque.obterProdutoMaisBarato();
        System.out.println("Produto mais barato: " + produtoMaisBarato);

        // Obtém e exibe o produto com a maior quantidade em valor no estoque
        Produto produtoMaiorQuantidadeValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
        System.out.println("Produto com maior quantidade em valor no estoque: " + produtoMaiorQuantidadeValorTotal);
    }
}
