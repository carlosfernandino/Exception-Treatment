package application;

import entities.Account;
import exceptions.BusinessException;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import static entities.Account.escritor;

public class Application {
    public static void main(String[] args) throws IOException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe os dados da conta");
        System.out.print("Número: ");
        int number = sc.nextInt();
        System.out.print("Titular: ");
        sc.nextLine();    //Consumir o enter antes de armazenar o nome do titular
        String holder = sc.nextLine();
        System.out.println("Saldo Inicial: ");
        double balance = sc.nextDouble();
        System.out.println("Limite de saque: ");
        double withdrawLimit = sc.nextDouble();

        Account acc = new Account(number, holder, balance, withdrawLimit);

        System.out.println();
        System.out.println("Informe uma quantia para sacar: ");
        double amount = sc.nextDouble();

        try {
            acc.withdraw(amount);
            System.out.printf("Novo saldo: %.2f%n", acc.getBalance());

        }catch (BusinessException e){
            System.out.println(e.getMessage());
            escritor("Ocorreu uma exceção: " + e.getMessage());
        }

        sc.close();
    }
}