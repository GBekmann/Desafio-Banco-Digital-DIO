package app;

import java.util.Scanner;

public class ClientMenu {
    boolean clientMenu;

    public void openClientMenu(BankConsoleMenu bankMenu, Scanner scanner) {
        clientMenu = true;

        while (clientMenu) {
            showClientMenuOptions(bankMenu);

            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    System.out.println("Verificar extratos aqui");
                    //Perguntar se quer ver de corrente ou de poupança
                    break;

                case 2:
                    System.out.println("Realizar transferência aqui...");
                    break;

                case 3:
                    System.out.println("Realizar saque aqui...");
                    break;

                case 4:
                    System.out.println("Realizar depósito...");
                    break;

                case 9:
                    bankMenu.hideLastMenu();
                    clientMenu = false;
                    break;

                case 0:
                    clientMenu = false;
                    bankMenu.stopApplication();
                    break;
            }
        }
    }

    private void showClientMenuOptions(BankConsoleMenu bankMenu) {
        System.out.println("=====================================");
        System.out.println("----< Área do cliente >----");
        System.out.println("=====================================");
        System.out.println("1 - Verificar extrato");
        System.out.println("2 - Realizar transferência");
        System.out.println("3 - Realizar saque");
        System.out.println("4 - Realizar depósito");
        System.out.println("--------------------------------------");
        System.out.println("9 - Voltar");
        System.out.println("0 - Encerrar aplicação");
        System.out.println("--------------------------------------\n");
    }
}
