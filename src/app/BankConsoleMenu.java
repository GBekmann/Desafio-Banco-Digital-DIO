package app;

import java.util.Scanner;

public class BankConsoleMenu {
    Scanner scanner = new Scanner(System.in);

    boolean executionRunning = true;

    public void runBankSystem() {

        while (executionRunning) {
            System.out.println("\n===============================");
            System.out.println("----< DIO Bank Account >----");
            System.out.println("===============================");
            System.out.println("1 - Gerenciar cadastros");
            System.out.println("2 - Menu do Cliente");
            System.out.println("0 - Encerrar aplicativo");
            System.out.println("--------------------------------------");
            System.out.println("Digite a opção desejada");
            System.out.println("--------------------------------------\n");
            int userOption = scanner.nextInt();

                switch (userOption) {
                    case 1:
                        ManageClientsMenu gerenciadorDeCadastros = new ManageClientsMenu();
                        gerenciadorDeCadastros.openClientManagerMenu(this, scanner);
                        break;

                    case 2:
                        hideLastMenu();
                        ClientMenu menuClientes = new ClientMenu();
                        menuClientes.openClientMenu(this, scanner);
                        break;

                    case 0:
                      stopApplication();
                      break;

                }

            }
    }

    public void hideLastMenu() {
        System.out.println("\n\n\n\n\n\n1");
    }


    public void stopApplication(){
        hideLastMenu();
        System.out.println("===============================");
        System.out.println("Encerrando a aplicação...");
        System.out.println("===============================\n\n");
        executionRunning = false;
    }
}
