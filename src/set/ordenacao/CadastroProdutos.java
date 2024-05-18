package set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    public Set<Produto> produtoSet;
    public CadastroProdutos(){
        this.produtoSet = new HashSet<>();
    }
    public void adicionarProduto(long cod, String nome, double preco, int quantidade){
        produtoSet.add(new Produto(cod, nome, quantidade, preco));
    }
    public Set<Produto> exibirProdutosPorNome(){
        Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);
        if(!produtosPorNome.isEmpty()){
            return produtosPorNome;
        }else{
            throw new RuntimeException("o conjunto está vazio");
        }
    }
    public Set<Produto> exibirProdutosPorPreco(){
        Set<Produto> produtosOrdenadosPorPreco = new TreeSet<>(new ComparaProdutoPorPreco());
        if(!produtoSet.isEmpty()){
            produtosOrdenadosPorPreco.addAll(produtoSet);
            return produtosOrdenadosPorPreco;
        }else{
            throw new RuntimeException("o conjunto está vazio");
        }
    }
    public static void main(String[] args){
        // Criando uma instância do CadastroProdutos
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        // Adicionando produtos ao cadastro
        cadastroProdutos.adicionarProduto(1L, "Smartphone", 1000d, 10);
        cadastroProdutos.adicionarProduto(2L, "Notebook", 1500d, 5);
        cadastroProdutos.adicionarProduto(1L, "Mouse", 30d, 20);
        cadastroProdutos.adicionarProduto(4L, "Teclado", 50d, 15);

        // Exibindo todos os produtos no cadastro
        System.out.println(cadastroProdutos.produtoSet);

        // Exibindo produtos ordenados por nome
        System.out.println(cadastroProdutos.exibirProdutosPorNome());

        // Exibindo produtos ordenados por preço
        System.out.println(cadastroProdutos.exibirProdutosPorPreco());
    }
}
