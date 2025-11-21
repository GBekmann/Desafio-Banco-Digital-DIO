package app;

import java.util.ArrayList;
import java.util.Scanner;
import model.Client;


public class ManageClientsMenu {
    boolean clientManager;
    ArrayList<Client> clientList = new ArrayList<Client>();

    public void openClientManagerMenu(BankConsoleMenu bankMenu ,Scanner scanner) {
        clientManager = true;

        while (clientManager) {

            showClientManagerOptions(bankMenu);

            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch(userInput) {
                case 1:
                    showAllClients();
                    break;

                case 2:
                    createCustomerAccount(scanner);
                    System.out.println("\n\n============================================");
                    System.out.println("----< Cadastro criado com sucesso! >----");
                    System.out.println("============================================");
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
        System.out.println("--------------------------------------");
        System.out.println("9 - Voltar");
        System.out.println("0 - Encerrar aplicação");
        System.out.println("--------------------------------------\n");
    }

    public void showAllClients(){

        System.out.println("============================================");
        System.out.println("Lista de clientes cadastrados");
        System.out.println("============================================");
        System.out.println("Total de clientes: " + clientList.size() );
        System.out.println("-------------------------------------------\n");

        int currentCustomersQuantity = 1;
        for (Client client : clientList) {

            System.out.println("---------------------------------------------");
            System.out.println("# Cadastro " + currentCustomersQuantity + "\n" );   //Tenho que pegar o número do índice
            System.out.println("# Nome do cliente:\n  "+ client.getName() + "\n");
            System.out.println("# Idade do cliente:\n  " + client.getAge() + " anos (" + client.getBirthdayStr() + ")\n");
            System.out.println("# CPF do cliente:\n  " +client.getCpf() + "\n");
            System.out.println("# E-mail do cliente:\n  " + client.getEmail());
            System.out.println("---------------------------------------------\n");

            currentCustomersQuantity++;
        }
    }

    private void createCustomerAccount(Scanner scanner){
        System.out.println("---------------------------------------------");
        System.out.println(" #  Informe o nome completo do cliente:");
        System.out.println("---------------------------------------------");
        String name = scanner.nextLine();

        System.out.println("---------------------------------------------");
        System.out.println(" #  Informe o CPF do cliente:");
        System.out.println("---------------------------------------------");
        String cpf = scanner.nextLine();

        System.out.println("---------------------------------------------");
        System.out.println(" #  Informe o e-mail do cliente:");
        System.out.println("---------------------------------------------");
        String email = scanner.nextLine();

        System.out.println("---------------------------------------------");
        System.out.println(" #  Informe a data de nascimento do cliente:");
        System.out.println("(dd/MM/yyyy)");
        System.out.println("---------------------------------------------");
        String birthdayStr = scanner.nextLine();


        Client newClient = new Client(name, cpf, email, birthdayStr);
        clientList.add(newClient);

    }
}
