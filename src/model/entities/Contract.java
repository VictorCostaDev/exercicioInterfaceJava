package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    
    private Integer number;
    private LocalDate date;
    private double totalPayment; 
    
    private List<Installment> installments = new ArrayList<>();


    public Contract(Integer number, LocalDate date, double totalPayment) {
        this.number = number;
        this.date = date;
        this.totalPayment = totalPayment;  
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public void addInstallment(Installment installment) {
        installments.add(installment);
    }

    public void removeInstallment(Installment installment) {
        installments.remove(installment);
    }
    
    public void printOfInstallments() {
        for (Installment installment : installments) {
            System.out.println(installment.getDate() + " - " + String.format("%.2f", installment.getValue()));
        }
    }
}
