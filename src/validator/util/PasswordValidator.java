package validator.util;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;


public class PasswordValidator {

    private static final List<Predicate<String>> RULES = List.of(
            Pattern.compile(".*[A-Z].*").asPredicate(),
            Pattern.compile(".*[a-z].*").asPredicate(),
            Pattern.compile(".*\\d.*").asPredicate(),
            Pattern.compile(".*[!?@#].*").asPredicate()
    );



    public static boolean isStrong(String password){
        return password != null
        && password.length() >= 8
        && RULES.stream().allMatch(rule -> rule.test(password));
    }

}
