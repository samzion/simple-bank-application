package oop;

import oop.bank.GTBTransfer;
import oop.bank.DefaultTransfer;
import oop.bank.ITransfer;
import oop.bank.UBATransfer;
import oop.models.Account;

import java.util.ArrayList;
import java.util.List;

public class TransferProcessor {

    public static boolean transfer(double amount, Account source, Account destination){
        DefaultTransfer genericTransfer = new DefaultTransfer();
        GTBTransfer gtbTransfer = new GTBTransfer();
        UBATransfer ubaTransfer = new UBATransfer();
        List<ITransfer> genericTransfers = new ArrayList<>();
        genericTransfers.add(gtbTransfer);
        genericTransfers.add(ubaTransfer);
        genericTransfers.add(genericTransfer);

        String bank = destination.getBank();


        for (ITransfer genericTransfer1: genericTransfers){
            String currentBank = genericTransfer1.getBank();
            if (bank.equals(currentBank) || currentBank.equals("generic")){
                genericTransfer1.transfer(amount, source, destination);
                break;
            }
        }
        return true;
    }
}