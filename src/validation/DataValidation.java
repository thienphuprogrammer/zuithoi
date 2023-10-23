package validation;

public class DataValidation {
    public static boolean isEmail(String email) {
        return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    }
    //the code starts with FS followed by 5 digits
    public static boolean isCode(String code) {
        return code.matches("^FS[0-9]{5}$");
    }
    public static boolean isPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^[0-9]{10}$");
    }
    public static boolean isName(String name) {
        return name.matches("^[a-zA-Z ]+$");
    }
    public static boolean isAddress(String address) {
        return address.matches("^[a-zA-Z0-9 ]+$");
    }
    //validate department is not empty
    public static boolean isDepartment(String department) {
        return !department.isEmpty();
    }
    //validate salary > 1500
    public static boolean isSalary(Double salary) {
        return salary > 1500;
    }
    //Every day absent will be deducted 100000
    public static boolean isAbsent(int absent) {
        return absent >= 0;
    }
}
