package enit.bank.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
@ToString
public class AccountTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transactionDbId;
    private Long transactionAccountCode;
    private Date transactionDate;
    private Long transactionAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountCode")
    private BankAccount account;
}
