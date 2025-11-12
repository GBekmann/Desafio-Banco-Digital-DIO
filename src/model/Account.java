package model;

public abstract class Account implements accountOperations {


    //Constantes
	private static final int DEFAULT_BRANCH = 1;
	private static int SEQUENTIAL = 1;


    //Atributos
	protected int branch;
	protected int number;
	protected double balance;
	protected Client client;

    //Constructor
	public Account(Client client) {
		this.branch = Account.DEFAULT_BRANCH;
		this.number = SEQUENTIAL++;
		this.client = client;
	}


    //Métodos
	@Override
	public void withdraw(double value) {
		balance -= balance;
	}       //Sacar

	@Override
	public void deposit(double balance) {
		balance += balance;
	}

	@Override
	public void transfer(double balance, accountOperations destinationAccount) {
		this.withdraw(balance);
		destinationAccount.deposit(balance);
	}

    protected void printCommonInfo() {                  //Imprimir informações comuns
        System.out.println(String.format("Titular: %s", this.client.getName()));
        System.out.println(String.format("Agencia: %d", this.branch));
        System.out.println(String.format("Numero: %d", this.number));
        System.out.println(String.format("Saldo: %.2f", this.balance));
    }


    //Getters & Setters

	public int getAgencia() {
		return branch;
	}

	public int getNumero() {
		return number;
	}

	public double getSaldo() {
		return balance;
	}

}
