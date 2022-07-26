package application;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.services.RegistrationOfInstallments;

public class App {
    public static void main(String[] args)  {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter constract data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Year of contract: ");
        int year = sc.nextInt();
        System.out.print("Month of contract: ");
        int month = sc.nextInt();
        System.out.print("day of contract: ");
        int day = sc.nextInt();
        System.out.print("Contract value: ");
        double totalPayment = sc.nextDouble();

        Contract contract = new Contract(number, LocalDate.of(year, month, day), totalPayment);

        System.out.print("Enter number of installments: ");
        int numberOfInstallments = sc.nextInt();

        RegistrationOfInstallments regInstallments = new RegistrationOfInstallments(numberOfInstallments);

        regInstallments.createInstallments(contract);

        System.out.println();
        System.out.println("Installments: ");
        contract.printOfInstallments();
        sc.close();

    }
}
