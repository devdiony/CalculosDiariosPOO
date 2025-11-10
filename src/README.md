Atividade Prática – Cálculos do Dia a Dia com POO

Este projeto é uma aplicação de console em Java que implementa vários cálculos do cotidiano, demonstrando os conceitos fundamentais da Programação Orientada a Objetos (POO), como Abstração, Herança, Polimorfismo e Encapsulamento.

O sistema utiliza um menu interativo para permitir ao usuário escolher qual cálculo deseja realizar, coletando os dados necessários e exibindo os resultados de forma formatada.

Cálculos Implementados

O programa é capaz de realizar os seguintes cálculos:

Salário Líquido: Calcula o salário líquido com base no salário bruto, descontos e benefícios.

IMC (Índice de Massa Corporal): Calcula o IMC e exibe a classificação de peso.

Juros (Simples e Composto): Calcula o montante final e o total de juros para ambos os tipos.

Conversão de Moeda: Converte um valor de Real (BRL) para qualquer outra moeda com base na cotação.

Consumo de Energia: Calcula o valor total da conta de energia com base no consumo em kWh e no custo por kWh.

Conceitos de POO Aplicados

Abstração: A classe Calculo é abstrata e define um "molde" (Template Method) para todos os cálculos (executar(), coletarEntradas(), calcular()).

Herança: Todas as classes de cálculo concretas (CalculoSalarioLiquido, CalculoIMC, etc.) herdam da classe Calculo, especializando seu comportamento.

Interface: A interface Exibivel define um contrato (exibirResultado()) que todas as classes de cálculo devem implementar.

Polimorfismo: A classe Main utiliza uma List<Calculo> para tratar todos os objetos de cálculo de forma genérica. Ao chamar o método executar() de cada item da lista, o Java (em tempo de execução) resolve qual implementação específica (CalculoIMC.executar(), CalculoJuros.executar(), etc.) deve ser chamada.

Diagrama de Classes (UML)

O diagrama abaixo ilustra a arquitetura do sistema, mostrando a classe abstrata Calculo, a interface Exibivel, as subclasses concretas e os relacionamentos.

classDiagram
direction LR

    %% Interface
    class Exibivel {
        <<Interface>>
        +exibirResultado(): void
    }

    %% Classe Abstrata (Template Method)
    class Calculo {
        <<Abstract>>
        #resultado: double
        +executar(): void
        #coletarEntradas(): void*
        #calcular(): void*
        #exibirResultado(): void*
    }

    %% Classes Concretas
    class CalculoSalarioLiquido {
        -salarioBruto: double
        -descontos: double
        -beneficios: double
        +coletarEntradas(): void
        +calcular(): void
        +exibirResultado(): void
    }

    class CalculoIMC {
        -peso: double
        -altura: double
        +coletarEntradas(): void
        +calcular(): void
        +exibirResultado(): void
    }

    class CalculoJuros {
        -capital: double
        -taxa: double
        -tempo: double
        +coletarEntradas(): void
        +calcular(): void
        +exibirResultado(): void
    }

    class CalculoConversaoMoeda {
        -valorOriginal: double
        -cotacao: double
        -nomeMoedaDestino: String
        +coletarEntradas(): void
        +calcular(): void
        +exibirResultado(): void
    }

    class CalculoConsumoEnergia {
        -consumoKWh: double
        -custoPorKWh: double
        +coletarEntradas(): void
        +calcular(): void
        +exibirResultado(): void
    }
    
    %% Classe Principal
    class Main {
        +main(String[] args): void
    }

    %% Relacionamentos
    Calculo ..|> Exibivel : implementa
    CalculoSalarioLiquido --|> Calculo : herda de
    CalculoIMC --|> Calculo : herda de
    CalculoJuros --|> Calculo : herda de
    CalculoConversaoMoeda --|> Calculo : herda de
    CalculoConsumoEnergia --|> Calculo : herda de
    
    Main ..> Calculo : usa (polimorfismo)
    Main ..> Scanner : usa


Como Executar

Clone o repositório.

Abra o projeto em uma IDE Java (como IntelliJ ou Eclipse).

Localize e execute o método main() na classe calculosdiarios.Main.

Siga as instruções no console para selecionar e testar os cálculos.

Exemplo de Saída do Console

===== CALCULADORA DO DIA A DIA =====
Qual cálculo deseja realizar?
1: Salário Líquido
2: IMC
3: Juros (Simples/Composto)
4: Conversão de Moeda (Real -> Outra)
5: Consumo de Energia
6: Executar TODOS os cálculos
0: Sair
Escolha: 2

--- Cálculo de IMC ---
Digite o seu peso (em kg, ex: 70.5): 80
Digite a sua altura (em metros, ex: 1.75): 1.78
--- Resultado (IMC) ---
Seu IMC é: 25.25
Classificação: Sobrepeso

===== CALCULADORA DO DIA A DIA =====
Qual cálculo deseja realizar?
[...]
Escolha: 0
Obrigado por usar a calculadora. Até mais!
