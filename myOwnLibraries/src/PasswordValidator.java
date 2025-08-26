public class PasswordValidator {

    // username regex: username can start with any character except numbers and underscore;
    // can only take alphanumeric characters and underscore alone.
    // must be at least 8 characters but not more than 30 xters.
    public static final String regularExpression = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^A-Za-z0-9]).{8,20}$";

    public static  boolean validatePassword (String password) {

        if (password.matches(PasswordValidator.regularExpression)) {
            System.out.println("Valid password");
            return true;
        } else {
            System.out.println("Invalid password");
            return false;
        }
    }
}
