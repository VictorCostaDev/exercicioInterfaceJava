package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class RegistrationOfInstallments {
    
    private Integer numberOfInstallments;
    
    public RegistrationOfInstallments(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public Integer getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }


    public void createInstallments(Contract contract) {

        double valueForEachInstallment = contract.getTotalPayment() / numberOfInstallments;
        

        for (int index = 1; index <= numberOfInstallments; index++) {
            LocalDate date = contract.getDate().plusMonths(index); 
            double simpleInterestRate = valueForEachInstallment * 0.01 * index;
            double initialValue = valueForEachInstallment + simpleInterestRate;
            double value = initialValue + (0.02 * initialValue) ;
            
            Installment installment = new Installment(date, value);
            contract.addInstallment(installment);
        }
    }
}
