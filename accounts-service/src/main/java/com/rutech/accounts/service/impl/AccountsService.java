package com.rutech.accounts.service.impl;

import com.rutech.accounts.dto.CustomerDTO;
import com.rutech.accounts.entity.Accounts;
import com.rutech.accounts.entity.Customer;
import com.rutech.accounts.etypes.AccountType;
import com.rutech.accounts.exceptions.CustomerAlreadyExistException;
import com.rutech.accounts.mapper.CustomerMapper;
import com.rutech.accounts.repository.AccountsRepository;
import com.rutech.accounts.repository.CustomerRepository;
import com.rutech.accounts.service.IAccountsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class AccountsService implements IAccountsService {

    AccountsRepository accountsRepository;
    CustomerRepository customerRepository;

    public AccountsService(AccountsRepository accountsRepository,
                           CustomerRepository customerRepository) {
        this.accountsRepository = accountsRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());

        customerRepository.findByMobileNumber(customer.getMobileNumber())
            .ifPresentOrElse((existingCustomer) -> {
                throw new CustomerAlreadyExistException(String.format("Customer already registered with given mobile number %s", existingCustomer.getMobileNumber()));
                }, () -> {
                customer.setCreatedBy("System");
                customer.setCreatedAt(LocalDateTime.now());
                Customer savedCustomer = customerRepository.save(customer);
                accountsRepository.save(createNewAccount(savedCustomer));
            });
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccounts = new Accounts();
        newAccounts.setCustomerId(customer.getCustomerId());
        long newAccountNumber = new Random().nextInt(900000000) + 1000000000L;

        newAccounts.setAccountNumber(newAccountNumber);
        newAccounts.setAccountType(AccountType.SAVINGS);
        newAccounts.setBranchAddress("Mumbai");

        newAccounts.setCreatedBy("System");
        newAccounts.setCreatedAt(LocalDateTime.now());
        return newAccounts;
    }

}
