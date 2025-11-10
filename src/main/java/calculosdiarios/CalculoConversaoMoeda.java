package calculosdiarios;

/**
 * Cálculo 3: Conversão de Moedas
 */
public class CalculoConversaoMoeda extends Calculo {

    private double valorOriginal;
    private double cotacao;
    private String nomeMoedaDestino;

    @Override
    protected void coletarEntradas() {
        scanner.nextLine(); // Limpa o buffer do scanner antes de ler Strings

        System.out.println("\n--- Conversor de Moeda (Real para outra moeda) ---");
        System.out.print("Digite o nome da moeda de destino (ex: Dolar, Euro): ");
        this.nomeMoedaDestino = scanner.nextLine();

        System.out.print("Digite o valor em Reais (R$) a ser convertido: ");
        this.valorOriginal = scanner.nextDouble();

        System.out.printf("Digite a cotação atual do %s (ex: 5.25): ", this.nomeMoedaDestino);
        this.cotacao = scanner.nextDouble();
    }

    @Override
    protected void calcular() {
        // Fórmula: Valor Convertido = Valor Original / Cotação
        if (this.cotacao > 0) {
            this.resultado = this.valorOriginal / this.cotacao;
        } else {
            this.resultado = 0; // Evita divisão por zero
        }
    }

    @Override
    public void exibirResultado() {
        System.out.printf("--- Resultado (Conversor de Moeda) ---%n");
        System.out.printf("Valor em Reais: R$ %.2f%n", this.valorOriginal);
        System.out.printf("Cotação do %s: R$ %.2f%n", this.nomeMoedaDestino, this.cotacao);
        System.out.printf("Valor convertido em %s: %.2f%n", this.nomeMoedaDestino, this.resultado);
    }
}