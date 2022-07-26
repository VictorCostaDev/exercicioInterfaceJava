package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
    
    private Integer number;
    private Date date;
    private double totalPayment; 
    
    List<Installment> installments = new ArrayList<>();


    public Contract() {}

    public Contract(Integer number, Date date, double totalPayment) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public List<Installment> getInstallments() {
        return installments;
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
