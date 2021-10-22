package enit.bank.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bnkAccDbId;

    private String accountOwnerName;
    private String accountPassword;
    private Long accountCode;
    private Date accountInitialDate;
    private Double accountInitialBalance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transactionDbId")
    private List<AccountTransaction> accountTransactionSet;
}
