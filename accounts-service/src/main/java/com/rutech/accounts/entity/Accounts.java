package com.rutech.accounts.entity;

import com.rutech.accounts.etypes.AccountType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Accounts extends BaseEntity {

    @Id
    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "account_type")
    private AccountType accountType;

    @Column(name = "branch_address")
    private String branchAddress;

}
