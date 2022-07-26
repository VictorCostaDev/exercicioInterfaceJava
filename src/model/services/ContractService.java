package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
    
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {
        double basicQuota = contract.getTotalPayment() / months;

        for (int index = 1; index <= months; index++) {
            double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, index);
            double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
            Date dueDate = addMonths(contract.getDate(), index);
            contract.getInstallments().add(new Installment(dueDate, fullQuota));
        }
    }

    private Date addMonths(Date date, int N) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, N);
        return calendar.getTime();
    }
}
