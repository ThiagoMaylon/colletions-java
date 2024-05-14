package pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> listaLivro;

    CatalogoLivros(){
        listaLivro = new ArrayList<>();
    }

    public void adionaLivro(String titulo, String autor, int anoPublicacao){
        listaLivro.add(new Livro(titulo, autor, anoPublicacao));
    }

    public void pesquisaPorAutor(String autor){
        List<Livro> livroPesquisados = new ArrayList<>();
        for(Livro livro : listaLivro){
            if(livro.getAutor().equalsIgnoreCase(autor)){
                livroPesquisados.add(livro);
            }
        }
        System.out.println("Livros encotrados:");
        for(Livro livro : livroPesquisados){
            System.out.printf("%s | %s | %d\n",livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao());
        }
    }
    public void pesquisaPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> livrosPesquisados = new ArrayList<>();
        for(Livro livro : listaLivro){
            if(livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal){
                livrosPesquisados.add(livro);
            }
        }
        System.out.println("Livros encotrados:");
        for(Livro livro : livrosPesquisados){
            System.out.printf("%s | %s | %d\n",livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao());
        }
    }
    public void pesquisaPorTitulo(String titulo){
        List<Livro> livrosPesquisados = new ArrayList<>();
        for(Livro livro : listaLivro){
            if(livro.getTitulo().equalsIgnoreCase(titulo)){
                livrosPesquisados.add(livro);
            }
        }
        System.out.println("Livros encotrados:");
        for(Livro livro : livrosPesquisados){
            System.out.printf("%s | %s | %d\n",livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao());
        }
    }

}
