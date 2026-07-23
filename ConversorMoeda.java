import java.util.Scanner;

public class ConversorMoeda {
  private static final double TAXA_DOLAR_PARA_REAL = 5.0;
  private static final int OP_REAL_PARA_DOLAR = 1;
  private static final int OP_DOLAR_PARA_REAL = 2;

  public static void main(String[] args) {
    try (Scanner entrada = new Scanner(System.in)) {
      System.out.println(exibirMenu());

      int opcao = lerOpcao(entrada);
      double valor = lerValor(entrada);

      System.out.println(formatarConversao(opcao, valor));
    }
  }

  private static String exibirMenu() {
    return "Conversor de Moeda: Real (BRL) <-> Dólar (USD)\n"
        + "1 - Real para Dólar\n"
        + "2 - Dólar para Real";
  }

  private static int lerOpcao(Scanner sc) {
    System.out.print("Opção: ");
    while (true) {
      if (sc.hasNextInt()) {
        int opcao = sc.nextInt();
        if (opcao == OP_REAL_PARA_DOLAR || opcao == OP_DOLAR_PARA_REAL) {
          return opcao;
        }
      } else {
        sc.next();
      }
      System.out.print("Entrada inválida. Digite 1 ou 2: ");
    }
  }

  private static double lerValor(Scanner sc) {
    System.out.print("Digite o valor a ser convertido: ");
    while (!sc.hasNextDouble()) {
      System.out.print("Valor inválido. Digite um número: ");
      sc.next();
    }
    return sc.nextDouble();
  }

  private static String formatarConversao(int opcao, double valor) {
    switch (opcao) {
    case OP_REAL_PARA_DOLAR:
      return String.format("R$ %.2f equivalem a US$ %.2f", valor,
                           valor / TAXA_DOLAR_PARA_REAL);
    case OP_DOLAR_PARA_REAL:
      return String.format("US$ %.2f equivalem a R$ %.2f", valor,
                           valor * TAXA_DOLAR_PARA_REAL);
    default:
      return "Opção inválida.";
    }
  }
}
