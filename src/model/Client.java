package model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import app.BankConsoleMenu;
import exceptions.*;

public class Client {

    //Atributos
    private String name;
    private String cpf;
    private String email;
    private String birthdayStr;
    private int age;
    private int clientID;

    //Geradir de ID
    private static int nextID = 1;


    //Constructor
    public Client(String name, String cpf, String email, String birthdayStr) {
        this.name = name;
        this.cpf = formatCpf(cpf);  //Pega o CPF do method que formata
        this.email = email;
        this.birthdayStr = formatDate(birthdayStr); //Formata a data
        this.age = ageCalculator(this.birthdayStr);  //Calcula a idade
        this.clientID = nextID++; //Criar method que gerará um inteiro aleatorio para atribuir ao cliente
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


    //Formatador de data
    private String formatDate(String rawDate) {
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        //Array com a formatação dos inputs de datas de nascimento
        DateTimeFormatter[] inputFormatters = new DateTimeFormatter[]{
                DateTimeFormatter.ofPattern("dd/MM/yyyy"), //Com barra
                DateTimeFormatter.ofPattern("ddMMyyyy")    //Sem barra
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


    //Formatador de cpf
    public static String formatCpf(String cpfRaw) throws InvalidCpfException {
        //Remove qualquer caractere que não seja um número
        String digits = cpfRaw.replaceAll("\\D", "");

        //Se digitos diferentes de 11, dispara:
        if (digits.length() != 11) {
            throw new InvalidCpfException(

                    "\n---------------------------------------------\n" +
                    "# ERRO #\n" +
                    "O CPF deve conter 11 dígitos numéricos.\n" +
                    "---------------------------------------------"
            );
        }

/*      Regex para formatar números
        \\d encontra oq é número
        \\D Encontra tudo oq não é número)
*/
        return digits.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");

    }
}
