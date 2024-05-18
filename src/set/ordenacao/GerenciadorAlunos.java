package set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private final Set<Aluno> alunoSet;

    public GerenciadorAlunos(){
        this.alunoSet = new HashSet<>();
    }
    public void adicionarAluno(String nome, Long matricula, double media){
        alunoSet.add(new Aluno(nome, matricula, media));
    }

    public void removerAlunoPorMatricula(long matricula){
        Aluno aluno = null;
        if(!alunoSet.isEmpty()){
            for(Aluno a : alunoSet){
                if(a.getMatricula() == matricula){
                    aluno = a;
                }
            }
            alunoSet.remove(aluno);
        }else{
            throw new RuntimeException("o conjunto está vazio");
        }
    }
    public Set<Aluno> exibirAlunosPorNome(){
        Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
        if(!alunosPorNome.isEmpty()){
            return alunosPorNome;
        }else{
            throw new RuntimeException("o conjunto está vazio");
        }
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparaPorNota());
        if(!alunoSet.isEmpty()){
            alunosPorNota.addAll(alunoSet);
            return alunosPorNota;
        }else{
            throw new RuntimeException("o conjunto está vazio");
        }
    }
    public Set<Aluno> exibirAlunos(){
        return alunoSet;
    }

    public static void main(String[] args){
        // Criando uma instância do GerenciadorAlunos
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        // Adicionando alunos ao gerenciador
        gerenciadorAlunos.adicionarAluno("João", 123456L, 7.5);
        gerenciadorAlunos.adicionarAluno("Maria", 123457L, 9.0);
        gerenciadorAlunos.adicionarAluno("Carlos", 123458L, 5.0);
        gerenciadorAlunos.adicionarAluno("Ana", 123459L, 6.8);

        // Exibindo todos os alunos no gerenciador
        System.out.println("Alunos no gerenciador:");
        System.out.println(gerenciadorAlunos.exibirAlunos());

        // Removendo um aluno com matrícula inválida e outro pelo número de matrícula
        gerenciadorAlunos.removerAlunoPorMatricula(000L);
        gerenciadorAlunos.removerAlunoPorMatricula(123457L);
        System.out.println(gerenciadorAlunos.exibirAlunos());

        // Exibindo alunos ordenados por nome
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());

        // Exibindo alunos ordenados por nota
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());
    }
}
