package enit.bank.service;

import enit.bank.domain.entity.AccountTransaction;
import enit.bank.domain.entity.BankAccount;
import enit.bank.domain.inteface.AccountManager;
import enit.bank.domain.inteface.FinancialService;
import enit.bank.repository.BankAccountRepo;
import enit.bank.repository.TransactionsRepo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@NoArgsConstructor
@Getter @Setter
public class BankService implements FinancialService, AccountManager {

    @Autowired
    BankAccountRepo bankAccountRepo;

    @Autowired
    TransactionsRepo transactionRepo;

    @Override
    public AccountTransaction MakeTransaction(AccountTransaction transaction) {
        transactionRepo.save(transaction );
        return transaction;
    }

    @Override
    public BankAccount CreateAccount(BankAccount bankAccount) {
        bankAccountRepo.save(bankAccount);
        return bankAccount;
    }
    public BankAccount getAccount(Long code){
        return bankAccountRepo.findByAccountCode(code);
    }
}
