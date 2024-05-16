import list.pesquisa.SomaNumeros;

public class Main {
    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();
        somaNumeros.adicionaNumero(1);
        somaNumeros.adicionaNumero(5);
        somaNumeros.adicionaNumero(10);
        somaNumeros.adicionaNumero(8);
        somaNumeros.adicionaNumero(9);
        System.out.println(somaNumeros.calcularSoma());
        System.out.println(somaNumeros.exibirNumeros());
        System.out.println(somaNumeros.encontrarMaiorNumero());
        System.out.println(somaNumeros.encontrarMenorNumero());
    }
}