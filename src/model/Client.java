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
        this.birthdayStr = formatDate(birthdayStr); //Formata a data
        this.age = ageCalculator(this.birthdayStr);  //Calcula a idade
        this.clientID = clientID; //Criar method que gerará um inteiro aleatorio para atribuir ao cliente
    }

    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdayStr() {
        return birthdayStr;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public int getClientID() {
        return clientID;
    }

    //Client Methods

    private String formatDate(String rawDate) {
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        //Array com a formatação dos inputs de datas de nascimento
        DateTimeFormatter[] inputFormatters = new DateTimeFormatter[]{
                DateTimeFormatter.ofPattern("dd/MM/yyyy"),
                DateTimeFormatter.ofPattern("ddMMyyyy")
        };
        
        //Tratamento de exceções para cada formatador de datas
        for (DateTimeFormatter formatter : inputFormatters) {

            try {
                LocalDate date = LocalDate.parse(rawDate, formatter);
                return date.format(outputFormatter);
            } catch (Exception e) {
                //Tentará o próximo formato...
            }
        }
        //Mensagem de erro
        throw new IllegalArgumentException("Formato de data inválido: " + rawDate);
    }
        
    //Method que calculará a idade
    private int ageCalculator(String outputFormatter) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(outputFormatter, formatter);
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
