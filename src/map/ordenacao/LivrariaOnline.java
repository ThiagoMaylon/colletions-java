package map.ordenacao;

import java.util.*;

public class LivrariaOnline {
    Map<String, Livro> livroMap;

    public LivrariaOnline(){
        this.livroMap = new HashMap<>();
    }
    public void adicionarLivro(String link, Livro livro){
        livroMap.put(link, livro);
    }

    public void removerLivro(String titulo){
        String link = null;
        if(!livroMap.containsKey(titulo)){
            for(Map.Entry<String, Livro> livro : livroMap.entrySet()){
                if(livro.getValue().getTitulo().equalsIgnoreCase(titulo)){
                    link = livro.getKey();
                }
            }
            livroMap.remove(link);
        }else{
            System.out.println("livro não encontrado");
        }
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco(){
        Map<String, Livro> livroPorPreco = new TreeMap<>(livroMap);
        if(!livroPorPreco.isEmpty()){
            return livroPorPreco;
        }else{
            throw new RuntimeException("nenhum livro encontrado");
        }
    }


    public void pesquisarLivrosPorAutor(String autor){
        List<Livro> livrosAutor = new ArrayList<>();
        for(Map.Entry<String, Livro> livro : livroMap.entrySet()){
            if(livro.getValue().getAutor().equalsIgnoreCase(autor)){
                livrosAutor.add(livro.getValue());
            }
        }
        for(Livro livro : livrosAutor){
            System.out.println(livro);
        }


    }
    public Livro obterLivroMaisCaro(){
        Livro maisCaro = null;
        List<Livro> livros = new ArrayList<>();
        if(!livroMap.isEmpty()){
            for(Map.Entry<String, Livro> livro : livroMap.entrySet()){
                livros.add(livro.getValue());
            }
            maisCaro = livros.getFirst();
            for(Livro livro : livros){
                if(livro.getPreco() > maisCaro.getPreco()){
                    maisCaro = livro;
                }
            }
            return maisCaro;
        }else{
            throw new RuntimeException("Nenhum livro encontrado");
        }
    }
    public Livro obterLivroMaisBarato(){
        Livro maisBarato = null;
        List<Livro> livros = new ArrayList<>();
        if(!livroMap.isEmpty()){
            for(Map.Entry<String, Livro> livro : livroMap.entrySet()){
                livros.add(livro.getValue());
            }
            maisBarato = livros.getFirst();
            for(Livro livro : livros){
                if(livro.getPreco() < maisBarato.getPreco()){
                    maisBarato = livro;
                }
            }
            return maisBarato;
        }else{
            throw new RuntimeException("Nenhum livro encontrado");
        }
    }
    public static void main(String[] args){
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        // Adiciona os livros à livraria online
        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", new Livro("A Revolução dos Bichos", "George Orwell", 7.05d));
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", new Livro("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", new Livro("Malorie", "Josh Malerman", 5d));
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", new Livro("E Não Sobrou Nenhum", "Agatha Christie", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

        // Exibe todos os livros ordenados por preço
        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        // Pesquisa livros por autor
        String autorPesquisa = "Josh Malerman";
        livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

        // Obtém e exibe o livro mais caro
        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        // Obtém e exibe o livro mais barato
        System.out.println("Livro mais barato: " + livrariaOnline.obterLivroMaisBarato());

        // Remover um livro pelo título
        livrariaOnline.removerLivro("1984");
        System.out.println(livrariaOnline.livroMap);
    }
}
