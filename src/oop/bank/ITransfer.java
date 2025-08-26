package oop.bank;

import oop.models.Account;

public interface ITransfer {
     boolean transfer(double amount, Account source, Account destination);
     String getBank();
}

