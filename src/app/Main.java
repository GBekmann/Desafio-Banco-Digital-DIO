package app;

import model.*;

public class Main {

	public static void main(String[] args) {

		Client venilton = new Client();
		venilton.setName("Venilton");
		
		Account cc = new CheckingAccount(venilton);
		Account poupanca = new savingsAccount(venilton);

		cc.deposit(100);
		cc.transfer(100, poupanca);
		
		cc.printStatement();
		poupanca.printStatement();
	}

}
