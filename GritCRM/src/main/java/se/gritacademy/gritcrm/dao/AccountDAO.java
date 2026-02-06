package se.gritacademy.gritcrm.dao;

import se.gritacademy.gritcrm.model.Account;

public class AccountDAO extends GenericDAO<Account, Integer> {

    public AccountDAO() {
        super(Account.class);
    }

}
