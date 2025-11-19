package model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Client {

    //Atributos
	private String name;
    private String cpf;
    private String email;
    private String birthdayStr;
    private int age;
    private int clientID;


    //ArrayList


    //Constructor
    public Client(String name, String cpf, String email, String birthdayStr) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.birthdayStr = birthdayStr;
        this.clientID = clientID;
    }

    //Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getClientID() {
        return clientID;
    }


    private Period ageValidator(String birthdayStr) {
        //Data atual, formatação String
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        LocalDate birthday = LocalDate.parse(birthdayStr, formatador);

        LocalDate actualDate = LocalDate.now();

        //Calculadora de idade (Utiliza resultados da estrutura construída acima)
        Period age = Period.between(birthday, actualDate);
        System.out.println("Idade atual do cliente é" + age.getYears());

        return age;
    }



}
