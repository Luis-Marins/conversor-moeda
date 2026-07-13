import java.util.Scanner;

public class ConversorMoeda {
  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

    // Taxa de câmbio fixa (manual sem API)
    final double TAXA_DOLAR_PARA_REAL = 5.0;

    System.out.println("Conversor de Moeda: Real (BRL) <-> Dólar (USD)");
    System.out.println("Escolha a conversão:");
    System.out.println("1 - Real para Dólar");
    System.out.println("2 - Dólar para Real");
    System.out.print("Opção: ");

    int opcao = entrada.nextInt();

    System.out.print("Digite o valor a ser convertido: ");
    double valor = entrada.nextDouble();

    double resultado;

    if (opcao == 1) {
      // Real para Dólar: divide pela taxa
      resultado = valor / TAXA_DOLAR_PARA_REAL;
      System.out.printf("R$ %.2f equivalem a US$ %.2f%n", valor, resultado);
    } else if (opcao == 2) {
      // Dólar para Real: multiplica pela taxa
      resultado = valor * TAXA_DOLAR_PARA_REAL;
      System.out.printf("US$ %.2f equivalem a R$ %.2f%n", valor, resultado);
    } else {
      System.out.println("Opção inválida.");
    }

    entrada.close();
  }
}
