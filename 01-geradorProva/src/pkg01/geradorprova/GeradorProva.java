package pkg01.geradorprova;

import java.util.Scanner;

/**
 *
 * @author 6530729 = Luiz Zimmermann
 */
public class GeradorProva {

    //FUNÇÃO PARA OBTER OS DADOS DA PROVA
    public static void obtemInfo(Prova x) {

        Scanner scan = new Scanner(System.in);

        String frase;

        System.out.println("Por favor, informe o nome da disciplina: ");
        frase = scan.nextLine();
        x.setNomeDaDisciplina(frase);

        System.out.println("Por favor, informe o local da prova: ");
        frase = scan.nextLine();
        x.setLocal(frase);

        System.out.println("Por favor, informe a data em que a prova ira ser realizada: ");
        frase = scan.nextLine();
        x.setData(frase);

        System.out.println("Por favor, informe o peso da nota da prova: ");
        while (!scan.hasNextInt()) {
            System.out.println("Valor incorreto, por favor insira um valor valido: ");
            scan.next();
        }
        x.setPeso(scan.nextInt());

        scan.nextLine();
        System.out.println("");

    }

    //FUNÇÃO PARA OBTER OS DADOS DAS QUESTÕES DISCURSIVAS
    public static Discursiva[] obtemProvaD(Prova x) {

        Scanner scan = new Scanner(System.in);

        int num;
        double num2;
        String frase;

        System.out.println("Por favor, informe o numero de perguntas discursivas: ");

        while (!scan.hasNextInt()) {
            System.out.println("Valor incorreto, por favor insira um valor valido: ");
            scan.next();
        }

        num = scan.nextInt();
        Discursiva[] vet = new Discursiva[num];

        scan.nextLine();

        if (num >= 1) {
            System.out.println("Por favor, escreva as perguntas abaixo. ");
        } else {
            System.out.println("Nenhuma questao discursiva.\n");
        }
        for (int i = 0; i < vet.length; i++) {

            vet[i] = new Discursiva();
            //INFORMA A QUESTAO
            System.out.println("Pergunta numero " + (i + 1) + ": ");
            frase = scan.nextLine();
            vet[i].setPergunta(frase);
            System.out.println("");
            //PESO DA QUESTAO
            System.out.println("Informe o peso da questão: ");
            while (!scan.hasNextDouble()) {//verificação do peso
                System.out.println("Valor incorreto, por favor, insira um valor valido.");
                scan.next();
            }
            num2 = scan.nextDouble();
            vet[i].setPeso(num2);
            scan.nextLine();
            System.out.println("");
            //CRITERIOS DA QUESTAO
            System.out.println("Informe o critério de avaliação da questão");
            frase = scan.nextLine();
            vet[i].setCriteriosCorrecao(frase);
            System.out.println("\n");

        }

        //RETORNA O VETOR COM TODAS AS INFORMAÇOES SOBRE AS QUESTOES DISCURSIVAS
        return vet;
    }

    //FUNÇÃO PARA OBTER OS DADOS DAS QUESTÕES OBJETIVAS
    public static Objetiva[] obtemProvaO(Prova x) {

        Scanner scan = new Scanner(System.in);

        int num;
        double num2;
        String frase;

        System.out.println("Por favor, informe o numero de perguntas objetivas: ");

        while (!scan.hasNextInt()) {
            System.out.println("Valor incorreto, por favor insira um valor valido: ");
            scan.next();
        }

        num = scan.nextInt();
        Objetiva[] vet = new Objetiva[num];
        scan.nextLine();

        if (num >= 1) {
            System.out.println("Por favor, escreva as perguntas abaixo. ");
        } else {
            System.out.println("Nenhuma quetao objetiva.\n");
        }

        for (int i = 0; i < vet.length; i++) {
            //ALOCA UM ESPAÇO NA MEMORIA DO TIPO OBJETIVA PARA CADA POSIÇÃO DO VETOR
            vet[i] = new Objetiva();
            //QUESTÕES
            System.out.println("Pergunta numero " + (i + 1) + ": ");
            frase = scan.nextLine();
            vet[i].setPergunta(frase);
            //OPÇÕES
            System.out.println("Informe as 5 opções de resposta para a questão");
            String[] vetAux = new String[5];
            for (int j = 0; j < vetAux.length; j++) {
                System.out.println("Opção " + (j + 1) + ": ");
                frase = scan.nextLine();
                vetAux[j] = frase;
            }
            vet[i].setOpcoes(vetAux);
            //RESPOSTAS
            System.out.println("Informe o numero da alternativa correta: ");

            while (!scan.hasNextInt()) {
                System.out.println("Valor incorreto, por favor insira um valor valido: ");
                scan.next();
            }
            num = scan.nextInt();
            vet[i].setRespostaCorreta(num);

            scan.nextLine();

            //PESOS
            System.out.println("Informe o peso da questão: ");

            while (!scan.hasNextDouble()) {
                System.out.println("Valor incorreto, por favor insira um valor valido: ");
                scan.next();
            }
            num2 = scan.nextDouble();
            vet[i].setPeso(num2);

            scan.nextLine();

        }

        return vet;
    }

    //FUNÇÃO MAIN DO PROGRAMA
    public static void main(String[] args) {

        Prova x = new Prova();

        obtemInfo(x);
        x.setQuestoesDiscursivas(obtemProvaD(x));
        x.setQuestoesObjetivas(obtemProvaO(x));

        System.out.println(x.obtemDetalhes());
        System.out.println(x.obtemProvaImpressao());

    }

}
