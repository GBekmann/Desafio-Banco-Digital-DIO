package model;

//Conta poupança
public class savingsAccount extends Account {

    //Constructor
	public savingsAccount(Client client) {
		super(client);
	}

    //Sobre-escrita de method
	@Override
	public void printStatement() {
        System.out.println("=====================================");
		System.out.println("----< Extrato Conta Poupança >----");
		super.printCommonInfo();
	}
}
