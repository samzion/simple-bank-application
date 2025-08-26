public class EmailValidator {


    public static final String regularExpression = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    public static  boolean validateEmail (String email) {

        if (email.matches(EmailValidator.regularExpression)) {
            System.out.println("Valid email");
            return true;
        } else {
            System.out.println("Invalid email");
            return false;
        }
    }
}
