package calculosdiarios;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Requisito: "Crie uma classe abstrata, por exemplo, Calculo"
 * Esta classe usa o Padrão de Projeto "Template Method".
 * O método concreto 'executar()' define o esqueleto da operação
 * e chama os métodos abstratos que as subclasses devem implementar.
 */
public abstract class Calculo implements Exibivel {

    // Scanner estático para ser compartilhado por todas as subclasses
    protected static Scanner scanner = new Scanner(System.in);

    // Atributo protegido para armazenar o resultado final do cálculo
    protected double resultado;

    /**
     * Requisito: "com o método abstrato executar()"
     * (Implementado como um "Template Method" concreto para reutilização)
     * Este é o "motor" que orquestra a ordem das operações.
     */
    public final void executar() {
        try {
            coletarEntradas();
            calcular();
            exibirResultado();
        } catch (InputMismatchException e) {
            System.out.println("\n[ERRO] Entrada inválida. Por favor, digite apenas números.");
            scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
        } catch (Exception e) {
            System.out.println("\n[ERRO] Ocorreu um problema: " + e.getMessage());
        }
    }

    /**
     * Método abstrato para coletar os dados de entrada específicos
     * de cada cálculo (via Scanner).
     */
    protected abstract void coletarEntradas();

    /**
     * Método abstrato para realizar a lógica de cálculo específica.
     */
    protected abstract void calcular();

    /**
     * Método abstrato da interface Exibivel, forçando as subclasses
     * a implementarem a exibição de seus resultados.
     */
    @Override
    public abstract void exibirResultado();
}