package oop.models.requests;

public class WithdrawRequest {
    private String accountNumber;
    private double withdrawAmount;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(double amount) {
        this.withdrawAmount = amount;
    }

    public static String validate(WithdrawRequest withdrawRequest){
        if(withdrawRequest == null){
            return "Deposit request cannot be null";
        }
        if(withdrawRequest.getAccountNumber() == null){
            return "Account number cannot be null";
        }
        if(withdrawRequest.getWithdrawAmount() < 100 ){
            return "Withdrawal Amount cannot be less than 100";
        }
        return "Withdrawal request okay!";
    }

}
