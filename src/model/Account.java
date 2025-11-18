package model;

public abstract class Account implements accountOperations {

    //Constantes
	private static final int DEFAULT_BRANCH = 1;
	private static int SEQUENTIAL = 1;

    //Atributos
	protected int branch;           //Agência
	protected int number;           //N° da conta
	protected double balance;       //Saldo da conta
	protected Client client;        //Cliente

    //Constructor
	public Account(Client client) {
		this.branch = Account.DEFAULT_BRANCH;
		this.number = SEQUENTIAL++;
		this.client = client;
	}


    //Métodos

    //Sacar
	@Override
	public void withdraw(double value) {
		balance -= balance;
	}

    //Depositar
	@Override
	public void deposit(double balance) {
		balance += balance;
	}

    //Transferir
	@Override
	public void transfer(double balance, accountOperations destinationAccount) {
		this.withdraw(balance);
		destinationAccount.deposit(balance);
	}

    //Imprimir informações comuns
    protected void printCommonInfo() {
        System.out.println("=====================================");
        System.out.println(String.format("Titular: %s", this.client.getName()));
        System.out.println(String.format("Agencia: %d", this.branch));
        System.out.println(String.format("Numero: %d", this.number));
        System.out.println(String.format("Saldo: %.2f", this.balance));
        System.out.println("=====================================\n");
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
