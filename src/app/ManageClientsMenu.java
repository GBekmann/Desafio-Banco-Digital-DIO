package app;

import java.util.Scanner;

public class ManageClientsMenu {
    boolean clientManager;

    public void openClientManagerMenu(BankConsoleMenu bankMenu ,Scanner scanner) {
        clientManager = true;

        while (clientManager) {

            showClientManagerOptions(bankMenu);

            int userInput = scanner.nextInt();

            switch(userInput) {
                case 1:
                    System.out.println("Lista de cadastros aqui");
                    break;

                case 2:
                    System.out.println("Criar cadastro aqui");
                    break;

                case 3:
                    System.out.println("Atualizar cadastro aqui");
                    break;

                case 4:
                    System.out.println("Apagar cadastro aqui");
                    break;

                case 9:
                    bankMenu.hideLastMenu();
                    clientManager = false;
                    break;

                case 0:
                    clientManager = false;
                    bankMenu.stopApplication();
                    break;

            }
        }
    }

    private void showClientManagerOptions(BankConsoleMenu bankMenu) {
        bankMenu.hideLastMenu();
        System.out.println("=====================================");
        System.out.println("----< Gerenciador de cadastros >----");
        System.out.println("=====================================");
        System.out.println("1 - Verificar lista de cadastros");
        System.out.println("2 - Criar novo cadastro");
        System.out.println("3 - Atualizar cadastro");
        System.out.println("4 - Apagar cadastro");
        System.out.println("=====================================");
        System.out.println("9 - Voltar");
        System.out.println("0 - Encerrar aplicação");
        System.out.println("=====================================");
    }
}
