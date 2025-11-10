package calculosdiarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Requisito: "Na classe principal (Main), crie um vetor ou lista de cálculos"
 * Demonstra o Polimorfismo.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criamos uma lista do tipo ABSTRATO 'Calculo'
        List<Calculo> calculosDisponiveis = new ArrayList<>();

        // Adicionamos instâncias dos tipos CONCRETOS
        calculosDisponiveis.add(new CalculoSalarioLiquido());
        calculosDisponiveis.add(new CalculoIMC());
        calculosDisponiveis.add(new CalculoJuros());
        calculosDisponiveis.add(new CalculoConversaoMoeda());
        calculosDisponiveis.add(new CalculoConsumoEnergia());

        int escolha = -1;
        while (escolha != 0) {
            System.out.println("\n===== CALCULADORA DO DIA A DIA =====");
            System.out.println("Qual cálculo deseja realizar?");
            System.out.println("1: Salário Líquido");
            System.out.println("2: IMC");
            System.out.println("3: Juros (Simples/Composto)");
            System.out.println("4: Conversão de Moeda (Real -> Outra)");
            System.out.println("5: Consumo de Energia");
            System.out.println("6: Executar TODOS os cálculos");
            System.out.println("0: Sair");
            System.out.print("Escolha: ");

            try {
                escolha = scanner.nextInt();

                if (escolha > 0 && escolha <= 5) {
                    // Pega o cálculo escolhido da lista (índice é escolha-1)
                    // e chama o método de forma polimórfica.
                    calculosDisponiveis.get(escolha - 1).executar();

                } else if (escolha == 6) {
                    // Requisito: "invoque seus métodos de forma genérica"
                    System.out.println("\n--- EXECUTANDO TODOS OS CÁLCULOS ---");
                    for (Calculo calculo : calculosDisponiveis) {
                        calculo.executar();
                    }
                    System.out.println("\n--- TODOS OS CÁLCULOS FINALIZADOS ---");

                } else if (escolha < 0 || escolha > 6) {
                    System.out.println("Opção inválida. Tente novamente.");
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        }

        System.out.println("Obrigado por usar a calculadora. Até mais!");
        scanner.close();
    }
}