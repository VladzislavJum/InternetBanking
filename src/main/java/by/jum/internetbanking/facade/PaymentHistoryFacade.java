package by.jum.internetbanking.facade;

import by.jum.internetbanking.dto.PaymentHistoryDTO;
import by.jum.internetbanking.form.money.MoneyTransactionForm;
import by.jum.internetbanking.form.money.PaymentForServicesForm;

public interface PaymentHistoryFacade {
    PaymentHistoryDTO getHistoryById(Long id);

    void saveTransactionHistory(MoneyTransactionForm transactionForm);

    void savePaymentHistory(PaymentForServicesForm paymentForServicesForm);
}
