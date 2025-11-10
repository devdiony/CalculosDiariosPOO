package calculosdiarios;

/**
 * Cálculo 2: IMC (Índice de Massa Corporal)
 */
public class CalculoIMC extends Calculo {

    private double peso;
    private double altura;

    @Override
    protected void coletarEntradas() {
        System.out.println("\n--- Cálculo de IMC ---");
        System.out.print("Digite o seu peso (em kg, ex: 70.5): ");
        this.peso = scanner.nextDouble();

        System.out.print("Digite a sua altura (em metros, ex: 1.75): ");
        this.altura = scanner.nextDouble();
    }

    @Override
    protected void calcular() {
        // Fórmula: IMC = Peso / (Altura * Altura)
        if (this.altura > 0) {
            this.resultado = this.peso / (this.altura * this.altura);
        } else {
            this.resultado = 0; // Evita divisão por zero
        }
    }

    @Override
    public void exibirResultado() {
        System.out.println("--- Resultado (IMC) ---");
        System.out.printf("Seu IMC é: %.2f%n", this.resultado);

        // Classificação
        if (this.resultado < 18.5) {
            System.out.println("Classificação: Abaixo do peso");
        } else if (this.resultado < 24.9) {
            System.out.println("Classificação: Peso normal");
        } else if (this.resultado < 29.9) {
            System.out.println("Classificação: Sobrepeso");
        } else if (this.resultado < 34.9) {
            System.out.println("Classificação: Obesidade Grau I");
        } else if (this.resultado < 39.9) {
            System.out.println("Classificação: Obesidade Grau II");
        } else {
            System.out.println("Classificação: Obesidade Grau III (Mórbida)");
        }
    }
}