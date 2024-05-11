import list.operacoesBasicas.CarrinhoCompras;

public class Main {
    public static void main(String[] args) {
        CarrinhoCompras carrinho = new CarrinhoCompras();
        carrinho.adicionarItem("Feijão", 9.99, 3);
        carrinho.adicionarItem("Arroz", 19.99, 2);
        carrinho.adicionarItem("Oléo", 19.99, 2);
        carrinho.exibirItens();
        System.out.printf("total: %,.2f\n",carrinho.calculaValorTotal());
        carrinho.removeItem("oléo");
        carrinho.exibirItens();

    }
}