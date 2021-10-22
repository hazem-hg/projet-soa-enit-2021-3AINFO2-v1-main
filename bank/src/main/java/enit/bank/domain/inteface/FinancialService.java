package enit.bank.domain.inteface;

import enit.bank.domain.entity.AccountTransaction;

public interface FinancialService {
    AccountTransaction MakeTransaction(AccountTransaction acc);
}
