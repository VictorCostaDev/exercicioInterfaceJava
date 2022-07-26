package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;


public class App {
    public static void main(String[] args) throws ParseException{

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter constract data");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        Date date = sdf.parse(sc.next());
        System.out.print("Contract value: ");
        double totalPayment = sc.nextDouble();

        Contract contract = new Contract(number, date, totalPayment);

        ContractService cs = new ContractService(new PaypalService());
        
        System.out.print("Enter number of installments: ");
        int numberOfInstallments = sc.nextInt();

        cs.processContract(contract, numberOfInstallments);

        System.out.println();
        System.out.println("Installments: ");
        for (Installment it : contract.getInstallments()) {
            System.out.println(it);
        }
        sc.close();

    }
}
