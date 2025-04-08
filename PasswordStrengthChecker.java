import java.util.Scanner;
import java.util.regex.Pattern;

class PasswordStrengthChecker {

    public static String checkPasswordStrength(String password) {
        int strengthScore = 0;
        StringBuilder feedback = new StringBuilder();

        // Check length
        if (password.length() >= 8) {
            strengthScore++;
        } else {
            feedback.append("- Password should be at least 8 characters long.\n");
        }

        // Check uppercase letters
        if (Pattern.compile("[A-Z]").matcher(password).find()) {
            strengthScore++;
        } else {
            feedback.append("- Add at least one uppercase letter.\n");
        }

        // Check lowercase letters
        if (Pattern.compile("[a-z]").matcher(password).find()) {
            strengthScore++;
        } else {
            feedback.append("- Add at least one lowercase letter.\n");
        }

        // Check numbers
        if (Pattern.compile("[0-9]").matcher(password).find()) {
            strengthScore++;
        } else {
            feedback.append("- Include at least one number.\n");
        }

        // Check special characters
        if (Pattern.compile("[!@#$%^&*(),.?\":{}|<>]").matcher(password).find()) {
            strengthScore++;
        } else {
            feedback.append("- Use at least one special character (!@#$%^&* etc.).\n");
        }

        // Determine password strength
        String strengthLevel;
        if (strengthScore == 5) {
            strengthLevel = "Strong";
        } else if (strengthScore >= 3) {
            strengthLevel = "Medium";
        } else {
            strengthLevel = "Weak";
        }

        // Output result
        return "Password Strength: " + strengthLevel + "\n" + (feedback.length() > 0 ? "Suggestions:\n" + feedback : "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password to check its strength: ");
        String password = scanner.nextLine();
        scanner.close();

        System.out.println(checkPasswordStrength(password));
    }
}