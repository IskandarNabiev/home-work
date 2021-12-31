package com.sbrf.reboot.repository;

import java.util.Set;

public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public boolean isClientHasContract(long clientId, long contractNumber) {
        Set<Long> accounts = accountRepository.getAllAccountsByClientId(clientId);
        for(Long account : accounts){
            if(account == contractNumber)
                return true;
        }
        return false;
    }

    public String addContract(long clientId, long contractNumber) {
        if (isClientHasContract(clientId, contractNumber)) {
            return "Client already has contract";
        } else {
            accountRepository.addClientContract(clientId, contractNumber);
            return "Contract created";
        }
    }
}
