package model;

//Conta Corrente
public class CheckingAccount extends Account {

    //Constructor
	public CheckingAccount(Client client) {
		super(client);
	}

    //Sobre-escrita de method
    @Override
	public void printStatement() {                          //Imprimir extrato
		System.out.println("=== Extrato Conta Corrente ===");
		super.printCommonInfo();
	}
	
}
