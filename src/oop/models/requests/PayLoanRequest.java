package oop.models.requests;

public class PayLoanRequest {
    private String sourceAccountNumber;
    private double Amount;

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public void setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public static String validate(PayLoanRequest payLoanRequest) {
        if (payLoanRequest == null) {
            return "Pay loan request cannot be null";
        }
        if (payLoanRequest.getSourceAccountNumber() == null) {
            return "Destination account number cannot be null";
        }

        if (payLoanRequest.getAmount() < 100) {
            return "Loan amount cannot be less than 100";
        }
            return "Pay loan request okay!";
    }
}
