package oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import oop.bank.*;


public class Main {

    public static void main(String[] args) {

//        DefaultTransfer genericTransfer = new DefaultTransfer();
//        GTBTransfer gtbTransfer = new GTBTransfer();
//        UBATransfer ubaTransfer = new UBATransfer();
//        List<DefaultTransfer> genericTransfers = new ArrayList<>();
//        genericTransfers.add(gtbTransfer);
//        genericTransfers.add(ubaTransfer);
//        genericTransfers.add(genericTransfer);
//
//        String bank = "gtb";
//        int amount = 10;
//        String source = "Ayo";
//        String destination = "Mark";
//
//        for (DefaultTransfer genericTransfer1: genericTransfers){
//            String currentBank = genericTransfer1.getBank();
//            if (bank.equals(currentBank) || currentBank.equals("generic")){
//                genericTransfer1.transfer(amount, source, destination);
//                break;
//            }
//        }
//    }
//
//        List<Account> accounts = new ArrayList<>();
//        Account samsonBank = new Account("Central Account", "000", "generic");
//        samsonBank.deposit(10000000);
//        double initialSamsonBankBalance =samsonBank.getBalance();
//
//        Account ayo = new Account("Ayo", "Gen01", "gtb");
//        Account kunle = new Account("Kunle", "Gen02", "uba");
//        Account emeka = new Account("Emeka", "Gen03", "generic");
//        Account mohammed = new Account("Mohammed", "Gen04", "uba");
//        Account mary = new Account("Mary", "Gen05", "gtb");
//
//        ayo.deposit(20000);
//        kunle.deposit(10000);
//        emeka.deposit(15000);
//        mohammed.deposit(55000);
//        mary.deposit(140000);
//
////        DefaultTransfer transferGeneric = new DefaultTransfer();
////        DefaultTransfer transferGTB = new GTBTransfer();
////        DefaultTransfer transferUBA = new UBATransfer();
////
//        accounts.add(ayo);
//        accounts.add(kunle);
//        accounts.add(emeka);
//        accounts.add(mohammed);
//        accounts.add(mary);
////        transferGeneric.transfer(10000, ayo, kunle);
//        double sum = 0;
//        for(Account account: accounts){
//            sum+=account.getBalance();
//        }
//        System.out.println("total balance of all accounts is " + sum);
//        for(int i = 0; i< 100; i++){
//            Random random = new Random();
//            int payOrCollectLoan = random.nextInt( 1, 3);
//            if(payOrCollectLoan == 1){
//                accounts.get(random.nextInt(0, 5)).collectLoan(random.nextInt(10000,     250000), samsonBank );
//            } else {
//                accounts.get(random.nextInt(0, 5)).payLoan(random.nextInt(10000,     250000), samsonBank );
//            }
//        }
//        double finalSum = 0;
//        for(Account account: accounts){
//            System.out.println(account.getBalance());
//            finalSum+=account.getBalance();
//        }
//        System.out.println("final total balance of all accounts is " + finalSum);
//        System.out.println("SamsonBank final balance is " + samsonBank.getBalance());
//        if(Math.abs(finalSum - sum) == Math.abs(initialSamsonBankBalance - samsonBank.getBalance())){
//            System.out.println("Balanced! Logic looks good.");
//        } else {
//            System.out.println("Ünbalanced! Logic looks re-evaluating.");
//        }
//
//        for(Account account : accounts){
//            System.out.println();
//            System.out.println();
//            System.out.println("##################################################################################");
//            System.out.println("AccountName" + "     "    + " TotalCredit  " + "     "  +  " TotalDebit" + "       "+ "CurrentBalance");
//            System.out.println(account.toString());
//            System.out.println("##################################################################################");
//        }
    }



//        ayo.deposit(20000);
//        System.out.println("Ayo balance is " + ayo.getBalance());
//        ayo.deposit(20000);
//        System.out.println("Ayo balance is "+ ayo.getBalance());
//        kunle.withdraw( 20000);
}
