import java.util.concurrent.atomic.AtomicLong;

public class AccountNumberGenerator {
    private static final AtomicLong counter = new AtomicLong(1000000000L); // start from 10-digit

    public static String generateAccountNumber() {
        System.out.println("Account creation successful!");
        return String.valueOf(counter.getAndIncrement());
    }

}