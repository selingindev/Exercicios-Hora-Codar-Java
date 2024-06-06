package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner entrada;

    public static void main(String[] args) {
       entrada = new Scanner(System.in);

        ex20();
    }

    private static void ex25() {
        //Escreva um programa que para ler doze números informados pelo usuário e que serão armazenados em um vetor/array.
        //
        //No fim o programa deve dar duas saídas:
        //1) o programa deve processar os dados invertendo a posição dos elementos trocando o primeiro elemento com o último, o segundo com penúltimo etc.
        //2) o programa deve processar os dados invertendo a posição dos elementos trocando, mas separando os dados por tipo.

        String[] array = new String[12];
        System.out.println("Informe doze elementos (letras ou números):");
        for (int i = 0; i < 12; i++) {
            array[i] = entrada.next();
        }

        // Saída 1: Inversão simples
        String[] invertidoSimples = new String[12];
        for (int i = 0; i < 12; i++) {
            invertidoSimples[i] = array[11 - i];
        }
        System.out.println("Saída 1: Inversão simples");
        for (String elemento : invertidoSimples) {
            System.out.print(elemento + " ");
        }
        System.out.println();

        String[] numeros = new String[12];
        String[] letras = new String[12];
        int numCount = 0;
        int letraCount = 0;

        for (String elemento : array) {
            if (Character.isDigit(elemento.charAt(0))) {
                numeros[numCount++] = elemento;
            } else {
                letras[letraCount++] = elemento;
            }
        }

        String[] numerosInvertidos = new String[numCount];
        for (int i = 0; i < numCount; i++) {
            numerosInvertidos[i] = numeros[numCount - 1 - i];
        }

        String[] letrasInvertidas = new String[letraCount];
        for (int i = 0; i < letraCount; i++) {
            letrasInvertidas[i] = letras[letraCount - 1 - i];
        }
        System.out.println("Saída 2: Inversão separada por tipo");
        for (String numero : numerosInvertidos) {
            System.out.print(numero + " ");
        }
        System.out.print(" - ");
        for (String letra : letrasInvertidas) {
            System.out.print(letra + " ");
        }
        System.out.println();
    }

    private static void ex24() {
        //A jornada de trabalho semanal de um funcionário é de 40 horas. O funcionário que trabalhar mais de 40 horas receberá hora extra, cujo cálculo é o valor da hora regular com um acréscimo de 50%.
        //
        //Escreva um programa que leia o número de horas trabalhadas em um mês, o salário por hora e escreva o salário total do funcionário, que deverá ser acrescido das horas extras, caso tenham sido trabalhadas (considere que o mês possua 4 semanas exatas)
        System.out.println("Informe quantas horas você trabalhou esse mês");
        int horasTrabalhadas = entrada.nextInt();

        System.out.println("Informe seu salário por hora");
        double salarioHora = entrada.nextDouble();

        if (horasTrabalhadas < 160) {
            throw new RuntimeException("Um trabalhador não pode ter menos que 160 horas por mês");
        }

        int horasNormais = 160;
        int horasExtras = horasTrabalhadas - horasNormais;

        double salarioHoraExtra = salarioHora * 1.5;
        double valorHorasExtras = horasExtras * salarioHoraExtra;

        double salarioTotal = (horasNormais * salarioHora) + valorHorasExtras;

        System.out.println("Seu salário deve ser de " + salarioTotal);
    }

    private static void ex23() {
        // Escreva um algoritmo que imprima as seguintes seqüências de números:
        //
        //(1, 1 2 3 4 5 6 7 8 9 10)
        //(2, 1 2 3 4 5 6 7 8 9 10)
        //(3, 1 2 3 4 5 6 7 8 9 10)
        //
        //E assim sucessivamente, até que o primeiro número (antes da vírgula), também chegue a 20.
        for (int i = 1; i <= 20; i++) {
            System.out.print("(" + i + ", ");
            for (int j = 1; j <= 10; j++) {
                System.out.print(j);
                if (j == 10) {
                    System.out.print(")");
                    System.out.println();
                }
            }
        }
    }

    private static void ex22() {
        //Escreva um algoritmo que imprima as seguintes seqüências de números:
        //
        //(1, 1 2 3 4 5 6 7 8 9 10)
        //(2, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
        //(3, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30)
        //
        //E assim sucessivamente, até que o primeiro número (antes da vírgula), também chegue a 20.
        int k=0;
            for (int i = 1; i <= 20; i++) {
            System.out.print("(" + i);
            for (int j = 1; j <= 10 ; j++) {
                k++;
                    System.out.print(", " + k);
                if (k == i*10) {
                    System.out.print(")");
                    System.out.println();
                }
            }
        }
    }

    private static void ex21() {
        // Uma empresa quer verificar se um empregado está qualificado para a aposentadoria ou não. Para estar em condições, um dos seguintes requisitos deve ser satisfeito:
        //
        // - Ter no mínimo 65 anos de idade.
        // - Ter trabalhado no mínimo 30 anos.
        // - Ter no mínimo 60 anos e ter trabalhado no mínimo 25 anos.
        //
        //Com base nas informações acima, faça um algoritmo que leia: o número do empregado (código), o ano de seu nascimento e o ano de seu ingresso na empresa. O programa deverá escrever a idade e o tempo de trabalho do empregado e a mensagem 'Requerer aposentadoria' ou 'Não requerer'.
        class Funcionario {
            private int id;
            private int anoNascimento;
            private int anoEmpregado;

            Funcionario(int id, int anoNascimento, int anoEmpregado) {
                this.id = id;
                this.anoNascimento = anoNascimento;
                this.anoEmpregado = anoEmpregado;
            }

            public void consultarAposentadoria() {
                if ((2024 - anoNascimento  >= 65)
                        || (2024 - anoEmpregado >= 30)
                        || (2024 - anoNascimento  >= 60 && 2024 - anoEmpregado >= 25)){
                    System.out.println("Requerer aposentadoria");
                    return;
                }
                System.out.println("Não requerer");
            }
        }
        Funcionario funcionario1 = new Funcionario(23213, 1959, 2000);

        funcionario1.consultarAposentadoria();
    }

    private static void ex20() {
        //20. CPF na nota?
        //Faça um programa para ler:
        //O nome do produto,
        //A quantidade adquirida do produto,
        //O preço unitário do produto.
        //Agora o programa deve calcular e escrever:
        //O valor da venda (valor da venda = quantidade adquirida * preço unitário),
        //O percentual de desconto,
        //O valor fixo de imposto que é 20%.
        //O total a pagar (total a pagar = valor da venda - desconto).
        //Sabendo-se que:
        //Se quantidade <= 5 o desconto será de 2%
        // -
        //Se quantidade > 5 e quantidade <=10 o desconto será de 3%
        // -
        //Se quantidade > 10 o desconto será de 5%
        //No fim, escreva um recibo que detalhe a compra como uma nota fiscal.

        class Produto {
            private String nome;
            private int quantidade;
            private double preco;
            private double valorVenda;
            private double desconto;
            private double valorTotal;

            public Produto(String nome, int quantidade, double preco) {
                this.nome = nome;
                this.quantidade = quantidade;
                this.preco = preco;
            }

            public void exibirRecibo() {
                valorVenda = quantidade * preco;
                if (quantidade <= 5) {
                    desconto = 0.98;
                }
                if (quantidade > 5 && quantidade <= 10) {
                    desconto = 0.97;
                }
                if (quantidade > 10) {
                    desconto = 0.95;
                }
                valorTotal = (valorVenda * 1.20);
                valorTotal *= desconto;
                System.out.println("Recibo: " +
                        "\nNome Produto: " + nome +
                        "\nQuantidade Produto: " + quantidade +
                        "\nPreço Produto: " + preco +
                        "\nValor Total: " + valorTotal);

            }
        }
        Produto produto1 = new Produto("Garrafinha Água", 10, 15.5);
        produto1.exibirRecibo();
    }

    private static void ex19() {
        //Crie um programa para ler 3 valores (A, B e C) representando as medidas dos lados de um triângulo e escrever se formam ou não um triângulo.
        //
        //Obs: para formar um triângulo, o valor de cada lado deve ser menor que a soma dos outros 2 lados.

                System.out.println("Digite o primeiro numero: ");
        double num1 = entrada.nextDouble();entrada.nextLine();

        System.out.println("Digite o segundo numero: ");
        double num2 = entrada.nextDouble();entrada.nextLine();

        System.out.println("Digite o terceiro numero: ");
        double num3 = entrada.nextDouble();entrada.nextLine();

        if (num1 < (num2 + num3) && num2 < (num1 + num3) && num3 < (num2 + num1)){
            System.out.println("Foi possível formar um triângulo! ");
            return;
        }
        System.out.println("Não foi possível formar um triângulo! ");
    }

    private static void ex18() {
        //Desenvolva um programa para uma revendedora de carros usados que calcula o salário final de seus funcionários vendedores. O algoritmo deve receber como entrada o número de carros vendidos, o valor total das vendas, o salário fixo mensal do vendedor e a comissão fixa por carro vendido.
        //
        //O salário final do vendedor é calculado somando o salário fixo mensal, a comissão fixa por carro vendido e 5% do valor total das vendas realizadas pelo vendedor.
        //
        //
        //Considere que o salário inicial é de R$ 5.000,00.
        //O Programa deve exibir e detalhar cada venda, a comissão e o percentual e exibir o valor final.
        double salarioFixo = 5000.00;
        System.out.println("Informe o número de carros vendidos: ");
        int carrosVendidos = entrada.nextInt();
        System.out.println("Informe o valor total das vendas: ");
        double valorTotalVendas = entrada.nextDouble();
        System.out.println("Informe a comissão fixa por carro vendido: ");
        double comissaoFixaPorCarro = entrada.nextDouble();
        double comissaoTotalPorCarros = carrosVendidos * comissaoFixaPorCarro;
        double comissaoPercentualSobreVendas = valorTotalVendas * 0.05;
        double salarioFinal = salarioFixo + comissaoTotalPorCarros + comissaoPercentualSobreVendas;
        System.out.println("Detalhes do salário do vendedor:");
        System.out.println("Salário fixo mensal: R$ " + salarioFixo);
        System.out.println("Número de carros vendidos: " + carrosVendidos);
        System.out.println("Comissão fixa por carro vendido: R$ " + comissaoFixaPorCarro);
        System.out.println("Comissão total por carros vendidos: R$ " + comissaoTotalPorCarros);
        System.out.println("5% do valor total das vendas: R$ " + comissaoPercentualSobreVendas);
        System.out.println("Salário final do vendedor: R$ " + salarioFinal);

    }

    private static void ex17() {
        //O custo de um carro novo ao consumidor é a soma do custo de fábrica com a porcentagem do distribuidor e dos impostos (aplicados ao custo de fábrica).
        //
        //Supondo que o percentual do distribuidor seja de 28% e os impostos de 45% sobre o valor da fábrica, escreva um programa para ler o custo de fábrica de um carro, calcular e escrever o custo final ao consumidor.
        double fabrica, distribuidora, custoFinal;
        System.out.print("informe o valor do carro na fabrica: ");
        fabrica = entrada.nextDouble();
        System.out.print("informe o valor cobrado pela distribuidora: ");
        distribuidora = entrada.nextDouble();
        fabrica += fabrica * 0.28;
        distribuidora = distribuidora * 1.45;
        custoFinal = fabrica + distribuidora;
        System.out.println("O Consumidor final pagará: " + custoFinal);
    }

    private static void ex16() {
    //Escreva um programa para ler:
        //o número total de eleitores de um município.
        //Agora o programa deve receber a quantindade (percentual):
        //o número de votos brancos;
        //o número de votos válidos;
        //o número de votos nulos.
        //Por fim, o programa vai calcular e escrever a quantidade de votos que cada categoria (brancos, nulos e válidos) representa em relação ao total
        //de eleitores.
        System.out.println("\nVamos calcular os votos! \nDigite o total de eleitores: ");
        int totalEleitores = entrada.nextInt();
        System.out.println("Digite o percentual de votos brancos");
        double pBrancos = entrada.nextDouble();
        System.out.println("Digite o percentual de votos válidos: ");
        double pValidos = entrada.nextDouble();
        System.out.println("Digite o percentual de votos nulos: ");
        double pNulos = entrada.nextDouble();
        double vBrancos = totalEleitores * (pBrancos / 100);
        double vValidos = totalEleitores * (pValidos / 100);
        double vNulos = totalEleitores * (pNulos / 100);
        System.out.println("\nQuantidade de votos de cada categoria: ");
        System.out.println("Votos brancos: " + vBrancos);
        System.out.println("Votos válidos: " + vValidos);
        System.out.println("Votos nulos: " + vNulos);
    }


    private static void ex15() {
        //Anacleto tem 1,50 metro e cresce 2 centímetros por ano, enquanto Felisberto tem 1,1O metro e cresce 3 centímetros por ano.
        //
        //Construa um programa que calcule e imprima quantos anos serão necessários para que Felisberto seja maior que Anacleto.


        int anos = 0;
        double altAnacleto = 1.50;
        double altFelisberto = 1.10;

        for (int i = 0; altAnacleto > altFelisberto; i++) {
            anos++;
            altAnacleto += 0.02;
            altFelisberto += 0.03;
        }

        System.out.println("Foram necessários " + anos + " anos para o Feliberto passar o Anacleto");
    }

    private static void ex14() {
        //Escreva um programa para ler 6 notas de um aluno, calcular e imprimir a média final. Considere que a nota de aprovação é 6,5. Logo após escrever a mensagem "Calcular a média de outro aluno Sim/Não?" e solicitar um resposta. Se a resposta for "S", o programa deve ser executado novamente, caso contrário deve ser encerrado exibindo a quantidade de alunos aprovados.
        double n1, n2, n3, n4, n5, n6, media = 0,aprovados = 0, reprovados = 0;
        String resp = "sim";
        while(resp.equals("sim")){
            System.out.println("digite a Primeira nota");
            n1 = entrada.nextDouble();
            System.out.println("digite a segunda nota");
            n2 = entrada.nextDouble();
            System.out.println("digite a terceira nota");
            n3 = entrada.nextDouble();
            System.out.println("digite a quarta nota");
            n4 = entrada.nextDouble();
            System.out.println("digite a quinta nota");
            n5 = entrada.nextDouble();
            System.out.println("digite a sextaa nota");
            n6 = entrada.nextDouble();
            media = (n1+n2+n3+n4+n5+n6) / 6;
            System.out.println("a média foi de: " + media);
            if(media <= 6.5) {
                System.out.println("faz o L");
                reprovados++;
            }else {
                System.out.println("aprovation");
                aprovados++;
            }
            System.out.println("deseja calcular outra média? ");
             resp = entrada.next();
        }

        System.out.println("a quantidade de alunos aprovados foi: " + aprovados);
        System.out.println("a quantidade de alunos reprovados foi: " + reprovados);

    }

    private static void ex13() {
        //Faça um algoritmo que calcule e escreva a média aritmética dos dois números inteiros informados pelo usuário e todos os números inteiros entre eles. Considere que o primeiro sempre será menor que o segundo.
        //Faça um algoritmo que calcule e escreva a média aritmética dos dois números inteiros informados pelo usuário e todos os números inteiros entre eles. Considere que o primeiro sempre será menor que o segundo.
        int nUm, nDois, count = 0;
        double media = 0;
        System.out.print("adicione o primeiro numero  menor que o segundo: ");
        nUm = entrada.nextInt();
        System.out.print("adicione o segundo numero: ");
        nDois = entrada.nextInt();
        do{
            count ++;
            media += nUm;
            nUm++;
        }while(nDois >= nUm);
        media = media / count;
        System.out.println("A média é: " + media);
    }

    private static void ex12() {
        //Escreva um algoritmo para imprimir os números de 1 (inclusive) a 10 (inclusive) em ordem decrescente.
        for(int i = 10; i > 0; i--){
            System.out.println(i);
        }

        }

    private static void ex11() {
        //Crie uma bomba relógio (usando somente código - para deixar claro!) cuja contagem regressiva vá de 30 a 0. Escreva a contagem em tela e no final da repetição escreva "EXPLOSÃO".
        int contador = 30;
        for (int i = 0; contador >= i; contador--) {
            System.out.println(contador);
            if (contador == 0) {
                System.out.println("Explodiu");
            }
        }
    }
    private static void ex10() {
        //Escreva um programa para ler as notas das 4 avaliações de um aluno no semestre, calcular e escrever a média do semestre e a seguinte mensagem: PARABÉNS! Você foi aprovado! somente se o aluno foi aprovado (considere 6.0 a média mínima para aprovação e 4 notas informadas).
        double n1, n2, n3, n4;
        double media;

        System.out.println("Digite a nota da primeira avaliação: ");
        n1 = entrada.nextDouble();

        System.out.println("Digite a nota da segunda avaliação: ");
        n2 = entrada.nextDouble();

        System.out.println("Digite a nota da terceira avaliação: ");
        n3 = entrada.nextDouble();

        System.out.println("Digite a nota da quarta avaliação: ");
        n4 = entrada.nextDouble();

        media = (n1 + n2 + n3 + n4)/ 4;

        System.out.println("\nMédia do semestre: " + media);

        if(media >= 6.0){
            System.out.println("PARABÉNS! Você foi aprovado!");
        }else{
            System.out.println("REPROVADO");
        }
    }

    private static void ex9() {
        //Faça um programa que leia 10 valores informados pelo usuário, calcule, exiba os números informados e escreva a média aritmética desses valores lidos.
                double soma = 0;
                int quantidade = 10;

                System.out.println("Digite " + quantidade + " valores:");

                for (int i = 1; i <= quantidade; i++) {
                    System.out.print("Valor " + i + ": ");
                    double valor = entrada.nextDouble();
                    soma += valor;
                }

                double media = soma / quantidade;

                System.out.println("\nA média aritmética é: " + media);
            }

    private static void ex8() {
        //Faça um programa para ler 2 valores informados pelo usuário e se o segundo valor informado for neutro, deve ser lido um novo valor - ou seja, para o segundo valor não pode ser aceito o valor zero nem um valor negativo. O programa deve imprimir o resultado da divisão do primeiro valor lido pelo segundo valor lido.
        int valor1 = 0;
        int valor2 = 0;

        do{
            System.out.println("Informe um valor");
            valor1 = entrada.nextInt();
            valor2 = entrada.nextInt();
        }while(valor2<=0);

        double resultado = valor1/valor2;

        System.out.println("Resultado: "+resultado);
    }

    private static void ex71() {
        //Faça um programa que leia 5  valores (considere que não serão informados valores iguais) e escrever a soma dos 2 maiores.
        System.out.println("informe o primeiro valor ");
        double valor1 = entrada.nextDouble();
        System.out.println("informe o segundo valor ");
        double valor2 = entrada.nextDouble();
        System.out.println("informe o terceiro valor ");
        double valor3 = entrada.nextDouble();
        System.out.println("informe o quarto valor ");
        double valor4 = entrada.nextDouble();
        System.out.println("informe o quinto valor ");
        double valor5 = entrada.nextDouble();

        double primeiroValorMaior = Math.max(valor1,valor2);
        double segundoValorMaior = Math.max(valor3,valor4);

        if (primeiroValorMaior < valor5){
            primeiroValorMaior = valor5;
        }else if(segundoValorMaior < valor5){
            segundoValorMaior = valor5;
        }

        double somaMaiorValor = primeiroValorMaior + segundoValorMaior;

        System.out.println("o maior valor dos cinco é: "+somaMaiorValor);


    }

    private static void ex7() {
        //Faça um programa que leia  3 valores (considere que não serão informados valores iguais) e escrever a soma dos 2 maiores.
        System.out.print("informe três valores distintos: ");
        int valor1 = entrada.nextInt();
        int valor2 = entrada.nextInt();
        int valor3 = entrada.nextInt();

        int soma;

        if (valor1 < valor2 && valor1 < valor3) {
            soma = valor2 + valor3;
        } else if (valor2 < valor3) {
            soma = valor1 + valor3;
        } else {
            soma = valor2 + valor1;
        }

        System.out.println("a soma dos valores é: " + soma);
    }

    private static void ex61() {
//Faça um programa para ler 4 valores (considere que não serão informados valores iguais) e escrever o maior deles.

        System.out.println("Digite o primeiro valor");
        double valor1 = entrada.nextDouble();

        System.out.println("Digite o segundo valor");
        double valor2 = entrada.nextDouble();


        System.out.println("Digite o terceiro valor");
        double valor3 = entrada.nextDouble();

        System.out.println("Digite o quarto valor");
        double valor4 = entrada.nextDouble();

        if(valor1 > valor2 && valor1 > valor3 && valor1 > valor4){
            System.out.println("O maior valor digitado é: Valor1");
        }else if(valor2 > valor3 && valor2 > valor4){
            System.out.println("O maior valor digitado é: Valor2");
        }else if(valor3 > valor4){
            System.out.println("O maior valor digitado é: Valor3");
        }else{
            System.out.println("O maior valor digitado é: Valor4");
        }
    }
    private static  void ex6(){
        //Faça um programa para ler 3 valores (considere que não serão informados valores iguais) e escrever o maior deles.
        System.out.print("Digite três valores diferentes: ");
        double valor1 = entrada.nextDouble();
        double valor2 = entrada.nextDouble();
        double valor3 = entrada.nextDouble();
        double maxValue = Math.max(valor1, Math.max(valor2, valor3));
        System.out.println("o maior valor é: " + maxValue);
    }

    private static void ex5(){
        //Faça um programa que leia um valor informado pelo usuário e diga se o valor informado é positivo, negativo ou neutro.
        System.out.print("informe o valor: ");
        double valor = entrada.nextDouble();
        if(valor > 0)
            System.out.println("o valor informado é positivo");
        else if(valor < 0)
            System.out.println("o valor informado é negativo");
        else
            System.out.println("o valor informado é neutro");
    }


    private static void ex4() {
        //Considerando a figura abaixo, escreva um programa para cada forma que calcule e exiba em tela cada uma de suas respectivas áreas. O usuário irá informar os valores de cada variável. Crie um arquivo para cada fórmula e poste os  arquivos no GitHub. Link do repositório abaixo.

        System.out.print("Digite a largura do retângulo: ");
        double largura = entrada.nextDouble();
        System.out.print("Digite a altura do retângulo: ");
        double altura = entrada.nextDouble();
        double area = largura * altura;
        System.out.println("A área do retângulo é: " + area);
        entrada.close();

        System.out.print("Informe um lado: ");
        double lado = entrada.nextDouble();
        area = lado * lado;
        System.out.println("A soma do quadrado é: " + area);


        System.out.print("Informe a diagonal maior: ");
        double diagonanalMaior = entrada.nextDouble();
        System.out.print("Informe a diagonal menor: ");
        double diagonanalMenor = entrada.nextDouble();
        area = diagonanalMaior * diagonanalMenor / 2;
        System.out.println("a area é: " + area);

        System.out.println("Calculo da área do trapézio");
        System.out.print("Informe a base maior: ");
        double baseMaior = entrada.nextDouble();
        System.out.print("Informe a base menor: ");
        double baseMenor = entrada.nextDouble();
        System.out.print("Informe a altura: ");
        altura = entrada.nextDouble();
        area = (baseMaior + baseMenor) * altura / 2;
        System.out.println("a area é: " + area);


        System.out.println("Calculo da área do paralelogramo");
        System.out.print("informe a base: ");
        double baseParalelogramo = entrada.nextDouble();
        System.out.print("informe a altura: ");
        double alturaParlelogramo = entrada.nextDouble();
        double areaParalelogaramo = baseParalelogramo * alturaParlelogramo;
        System.out.println("A área do paralelogramo é: " + areaParalelogaramo);


        System.out.println("\nCálculo da área do triângulo");
        System.out.print("informe a base: ");
        double baseTriangulo = entrada.nextDouble();
        System.out.print("informe a altura: ");
        double alturaTriangulo = entrada.nextDouble();
        double areaTriangulo = (baseTriangulo * alturaTriangulo) / 2;
        System.out.println("A área do triangulo é: " + areaTriangulo);


        System.out.println("\nCalculo da área do círculo");
        System.out.print("informe o raio: ");
        double raio = entrada.nextDouble();
        double areaCirculo = Math.PI * Math.pow(raio, 2);
        System.out.println("á area do circulo é: " + areaCirculo);
    }

    private static void ex3() {
        //Escreva um programa em Java em que o usuário informe o seu nome e em seguida o programa perguntará a idade do usuário. Agora o programa deve exibir a mensagem "Olá, [NomeDoUsuario], sua idade é [idade]".
        System.out.println("Digite seu nome: ");
        String nome = entrada.nextLine();
        System.out.println("Digite sua idade: ");
        int idade = entrada.nextInt();

        entrada.close();
        System.out.println("Olá, " + nome + ". Você tem "+ idade + " anos.");
    }

    private static void ex2() {//Escreva um programa em Java em que o usuário informe o seu nome e exiba a mensagem "Olá, [NomeDoUsuario]".

        System.out.println("Digite seu nome: ");
        String nome = entrada.nextLine();
        entrada.close();
        System.out.println("Olá, " + nome);
    }

    private static void ex1() {
        //Escreva um programa em Java e crie uma variável chamada "Planeta" e atribua-a um valor "Plutão".
        String planeta = "Plutão";
        System.out.println(planeta);
    }
    

}
