package model;
//Interface com os methods de contas bancárias

public interface accountOperations {
	
	void withdraw(double value);    //Sacar
	
	void deposit(double value);     //Depositar
	
	void transfer(double value, accountOperations destinationAccount);
	
	void printStatement();
}
