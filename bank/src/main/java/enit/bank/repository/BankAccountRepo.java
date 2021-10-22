package enit.bank.repository;

import enit.bank.domain.entity.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepo extends CrudRepository<BankAccount, Long> {
    BankAccount findByAccountCode(Long code);
}