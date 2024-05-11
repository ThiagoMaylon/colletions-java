package list.operacoesBasicas;

public class Tarefa {
    private String Descricao;
    Tarefa(String desc){
        this.Descricao = desc;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getDescricao() {
        return Descricao;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
