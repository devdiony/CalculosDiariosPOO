package calculosdiarios;

/**
 * Cálculo 1: Salário Líquido
 */
public class CalculoSalarioLiquido extends Calculo {

    private double salarioBruto;
    private double descontos;
    private double beneficios;

    @Override
    protected void coletarEntradas() {
        System.out.println("\n--- Cálculo de Salário Líquido ---");
        System.out.print("Digite o Salário Bruto (ex: 3000.00): R$ ");
        this.salarioBruto = scanner.nextDouble();

        System.out.print("Digite o total de Descontos (ex: 300.00): R$ ");
        this.descontos = scanner.nextDouble();

        System.out.print("Digite o total de Benefícios (ex: 150.00): R$ ");
        this.beneficios = scanner.nextDouble();
    }

    @Override
    protected void calcular() {
        // Fórmula: Salário Líquido = (Salário Bruto + Benefícios) - Descontos
        this.resultado = (this.salarioBruto + this.beneficios) - this.descontos;
    }

    @Override
    public void exibirResultado() {
        System.out.println("--- Resultado (Salário Líquido) ---");
        System.out.printf("Salário Bruto: R$ %.2f%n", this.salarioBruto);
        System.out.printf("Benefícios:    R$ %.2f%n", this.beneficios);
        System.out.printf("Descontos:     R$ %.2f%n", this.descontos);
        System.out.printf("Salário Líquido: R$ %.2f%n", this.resultado);
    }
}