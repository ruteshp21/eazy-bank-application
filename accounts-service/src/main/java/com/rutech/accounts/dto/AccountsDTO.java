package com.rutech.accounts.dto;

import com.rutech.accounts.etypes.AccountType;
import lombok.Data;

@Data
public class AccountsDTO {

    private Long accountNumber;
    private AccountType accountType;
    private String branchAddress;
}
