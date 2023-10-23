import employee.FullTimeEmployee;
import employee.PartTimeEmployee;

import static utilites.InputUtil.*;
import static utilites.OutputUtil.*;

public class ProgramMenu {
    private static Company company;

    static {
        try {
            company = new Company();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    enum Menu {
        EXIT,
        CREATE_A_NEW_FULL_TIME_EMPLOYEE,
        CREATE_A_NEW_PART_TIME_EMPLOYEE,
        PRINT_A_LIST_OF_FULL_TIME_EMPLOYEES,
        PRINT_A_LIST_OF_PART_TIME_EMPLOYEES
    }
    public void processMenu() {
        boolean exit = false;
        while (!exit) {
            printLineSeparate("Menu");
            printValueMenu("Employee");
            for (Menu menu : Menu.values()) {
                printValueMenu(menu.ordinal() + " to  " + menu.name().replace("_", " ").toLowerCase());
            }
            printLineSeparate();
            try {
                int choice = readInt("Enter your choice: ");
                if (choice < 0 || choice >= Menu.values().length) {
                    printValueln("Invalid choice.");
                } else {
                    switch (Menu.values()[choice]) {
                        case EXIT -> exit = true;
                        case CREATE_A_NEW_FULL_TIME_EMPLOYEE -> createFullTimeEmployee();
                        case CREATE_A_NEW_PART_TIME_EMPLOYEE -> createPartTimeEmployee();
                        case PRINT_A_LIST_OF_FULL_TIME_EMPLOYEES -> printFullTimeEmployees();
                        case PRINT_A_LIST_OF_PART_TIME_EMPLOYEES -> printPartTimeEmployees();
                        default -> {
                        }
                    }
                }
            } catch (Exception e) {
                printValueln("Invalid choice.");
            }
        }
    }
    private static void createFullTimeEmployee() {
        try {
            String code = readString("Enter code: ");
            String name = readString("Enter name: ");
            String phone = readString("Enter phone: ");
            String address = readString("Enter address: ");
            String department = readString("Enter department: ");
            double salary = readDouble("Enter salary: ");
            int absent = readInt("Enter absent: ");
            FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(code, name, phone, address, department, salary, absent);
            company.createFullTimeEmployee(fullTimeEmployee);
        } catch (Exception e) {
            printValueln(e.getMessage());
        }
    }
    private static void createPartTimeEmployee() {
        try {
            String code = readString("Enter code: ");
            String name = readString("Enter name: ");
            String phone = readString("Enter phone: ");
            String address = readString("Enter address: ");
            String department = readString("Enter department: ");
            int dailyWage = readInt("Enter daily wage: ");
            int present = readInt("Enter present: ");
            PartTimeEmployee partTimeEmployee = new PartTimeEmployee(code, name, phone, address, department, dailyWage, present);
            company.createPartTimeEmployee(partTimeEmployee);
        } catch (Exception e) {
            printValueln(e.getMessage());
        }
    }
    private static void printFullTimeEmployees() {
        company.printFullTimeEmployees();
    }
    private static void printPartTimeEmployees() {
        company.printPartTimeEmployees();
    }
}