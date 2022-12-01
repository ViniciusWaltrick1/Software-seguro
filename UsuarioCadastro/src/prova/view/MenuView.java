package prova.view;

import java.util.Scanner;

public class MenuView {

    public int menu() {

        int escolha;

        Scanner sc = new Scanner(System.in);

        System.out.println("Opcoes:" + System.lineSeparator() +
                "1 cadastrar" + System.lineSeparator() +
                "2 login" + System.lineSeparator() +
                "Digite sua opcao:");

        escolha = sc.nextInt();

        return escolha;

    }

}