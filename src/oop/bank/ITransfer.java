package oop.bank;

import oop.models.entities.Account;

public interface ITransfer {
     boolean transfer(double amount, Account source, Account destination);
     String getBank();
}

