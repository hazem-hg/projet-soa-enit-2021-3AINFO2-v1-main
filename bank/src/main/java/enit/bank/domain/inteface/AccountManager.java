package enit.bank.domain.inteface;

import enit.bank.domain.entity.BankAccount;

public interface AccountManager {
    BankAccount CreateAccount(BankAccount bancAccount);
}

/*https://quarkus.io/guides/spring-data-jpa*/