package calculosdiarios;

/**
 * Cálculo 5: Consumo de Energia Elétrica
 */
public class CalculoConsumoEnergia extends Calculo {

    private double consumoKWh;
    private double custoPorKWh;

    @Override
    protected void coletarEntradas() {
        System.out.println("\n--- Cálculo de Consumo de Energia ---");
        System.out.print("Digite o consumo total em kWh (ex: 150): ");
        this.consumoKWh = scanner.nextDouble();

        System.out.print("Digite o custo por kWh (R$, ex: 0.85): ");
        this.custoPorKWh = scanner.nextDouble();
    }

    @Override
    protected void calcular() {
        // Fórmula: Custo Total = Consumo (kWh) * Custo por kWh
        this.resultado = this.consumoKWh * this.custoPorKWh;
    }

    @Override
    public void exibirResultado() {
        System.out.println("--- Resultado (Consumo de Energia) ---");
        System.out.printf("Consumo: %.2f kWh%n", this.consumoKWh);
        System.out.printf("Custo/kWh: R$ %.2f%n", this.custoPorKWh);
        System.out.printf("Valor total da conta: R$ %.2f%n", this.resultado);
    }
}