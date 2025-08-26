public class UserNameValidator {

    // username regex: username can start with any character except numbers and underscore;
    // can only take alphanumeric characters and underscore alone.
    // must be at least 8 characters but not more than 30 xters.
    public static final String regularExpression = "^[a-zA-Z][a-zA-Z0-9_]{7,29}$";

    public static  boolean validateUserName (String userName) {

        if (userName.matches(UserNameValidator.regularExpression)) {
            System.out.println("Valid username");
            return true;
        } else {
            System.out.println("Invalid username");
            return false;
        }
    }
}
