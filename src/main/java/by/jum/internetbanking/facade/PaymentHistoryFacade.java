package by.jum.internetbanking.facade;

import by.jum.internetbanking.dto.PaymentHistoryDTO;
import by.jum.internetbanking.form.money.MoneyTransactionForm;

public interface PaymentHistoryFacade {
    PaymentHistoryDTO getHistoryById(Long id);

    void saveHistory(MoneyTransactionForm transactionForm);
}
