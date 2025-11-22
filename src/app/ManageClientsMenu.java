package app;

import java.util.ArrayList;
import java.util.Scanner;
import model.Client;
import exceptions.*;


public class ManageClientsMenu {
    boolean clientManager;
    ArrayList<Client> clientList = new ArrayList<Client>();

    public void openClientManagerMenu(BankConsoleMenu bankConsoleMenu ,Scanner scanner) {
        clientManager = true;

        while (clientManager) {

            showClientManagerOptions(bankConsoleMenu);

            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch(userInput) {

                //Criar cadastro
                case 1:
                    bankConsoleMenu.hideLastMenu();
                    createCustomerAccount(scanner, bankConsoleMenu);
                    break;

                //Apagar cadastro
                case 2:
                    System.out.println("Apagar cadastro aqui");
                    break;

                //Atualizar cadastros
                case 3:
                    System.out.println("Atualizar cadastro aqui");
                    break;

                //Lista de cadastros
                case 4:
                    showAllClients(bankConsoleMenu);
                    break;

                //Opções de voltar/encerrar
                case 9:
                    bankConsoleMenu.hideLastMenu();
                    clientManager = false;
                    break;

                case 0:
                    clientManager = false;
                    bankConsoleMenu.stopApplication();
                    break;

            }
        }
    }

    private void showClientManagerOptions(BankConsoleMenu bankConsoleMenu) {

        bankConsoleMenu.hideLastMenu();
        System.out.println("===================================");
        System.out.println("     Gerenciador de cadastros");
        System.out.println("===================================");
        System.out.println("1 - Criar novo cadastro");
        System.out.println("2 - Apagar cadastro");
        System.out.println("3 - Atualizar cadastro");
        System.out.println("4 - Verificar lista de cadastros");
        System.out.println("-----------------------------------");
        System.out.println("9 - Voltar");
        System.out.println("0 - Encerrar aplicação");
        System.out.println("-----------------------------------\n");
    }

    public void showAllClients(BankConsoleMenu bankConsoleMenu){

        bankConsoleMenu.hideLastMenu();
        System.out.println("============================================");
        System.out.println("Lista de clientes cadastrados");
        System.out.println("============================================");
        System.out.println("Total de clientes: " + clientList.size() );
        System.out.println("-------------------------------------------\n");

        int currentCustomersIndex = 1;   //Variável que será o índice da lista

        for (Client client : clientList) {

            System.out.println("---------------------------------------------");
            System.out.println("# Cadastro " + currentCustomersIndex + "\n" );
            System.out.println("# Nome do cliente:\n  "+ client.getName() + "\n");
            System.out.println("# Idade do cliente:\n  " + client.getAge() + " anos (" + client.getBirthdayStr() + ")\n");
            System.out.println("# CPF do cliente:\n  " + client.getCpf() + "\n");
            System.out.println("# E-mail do cliente:\n  " + client.getEmail()+ "\n");
            System.out.println("# ID do cadastro: (" + client.getClientID() + ")");
            System.out.println("---------------------------------------------\n");

            currentCustomersIndex++;
        }
    }

    private void createCustomerAccount(Scanner scanner, BankConsoleMenu bankConsoleMenu){
        try {
            bankConsoleMenu.hideLastMenu();
            System.out.println("=====================================");
            System.out.println(" #  Informe o nome completo do cliente:");
            String name = scanner.nextLine();
            System.out.println("=====================================");

            bankConsoleMenu.hideLastMenu();
            System.out.println("=====================================");
            System.out.println(" #  Informe o CPF do cliente:");
            String cpf = scanner.nextLine();
            System.out.println("=====================================");

            bankConsoleMenu.hideLastMenu();
            System.out.println("=====================================");
            System.out.println(" #  Informe o e-mail do cliente:");
            String email = scanner.nextLine();
            System.out.println("=====================================");

            bankConsoleMenu.hideLastMenu();
            System.out.println("===============================================");
            System.out.println(" #  Informe a data de nascimento do cliente:");
            System.out.println("(dd/MM/yyyy)");
            String birthdayStr = scanner.nextLine();
            System.out.println("===============================================");

            Client newClient = new Client(name, cpf, email, birthdayStr);
            clientList.add(newClient);
            bankConsoleMenu.hideLastMenu();

            System.out.println("=====================================");
            System.out.println("    Cadastro concluído");
            System.out.println("=====================================\n");

        } catch (InvalidCpfException e) {
            System.out.println(e.getMessage());
        }


    }
}

