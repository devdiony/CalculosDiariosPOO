package calculosdiarios;

/**
 * Cálculo 4: Juros Simples e Compostos
 */
public class CalculoJuros extends Calculo {

    private double capital;
    private double taxa;
    private double tempo;
    private int tipoJuros; // 1 para Simples, 2 para Composto
    private double montante;

    @Override
    protected void coletarEntradas() {
        System.out.println("\n--- Cálculo de Juros (Simples e Composto) ---");
        System.out.print("Digite o capital inicial (R$): ");
        this.capital = scanner.nextDouble();

        System.out.print("Digite a taxa de juros ao mês (ex: 2 para 2%): ");
        this.taxa = scanner.nextDouble() / 100.0; // Converte para decimal

        System.out.print("Digite o tempo (em meses): ");
        this.tempo = scanner.nextDouble();

        System.out.print("Digite o tipo de juros (1 para SIMPLES, 2 para COMPOSTO): ");
        this.tipoJuros = scanner.nextInt();
    }

    @Override
    protected void calcular() {
        if (this.tipoJuros == 1) {
            // Juros Simples: M = C * (1 + i * t)
            this.montante = this.capital * (1 + (this.taxa * this.tempo));
            this.resultado = this.montante - this.capital; // Resultado é o juro
        } else {
            // Juros Compostos: M = C * (1 + i)^t
            this.montante = this.capital * Math.pow((1 + this.taxa), this.tempo);
            this.resultado = this.montante - this.capital; // Resultado é o juro
        }
    }

    @Override
    public void exibirResultado() {
        String tipo = (this.tipoJuros == 1) ? "Simples" : "Composto";
        System.out.printf("--- Resultado (Juros %s) ---%n", tipo);
        System.out.printf("Capital Inicial: R$ %.2f%n", this.capital);
        System.out.printf("Total de Juros:  R$ %.2f%n", this.resultado);
        System.out.printf("Montante Final:  R$ %.2f%n", this.montante);
    }
}