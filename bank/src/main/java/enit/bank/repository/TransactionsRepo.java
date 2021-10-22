package enit.bank.repository;

import enit.bank.domain.entity.AccountTransaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionsRepo  extends CrudRepository<AccountTransaction, Long> {
}