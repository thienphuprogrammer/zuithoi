import employee.FullTimeEmployee;
import employee.PartTimeEmployee;

import java.util.ArrayList;

import static validation.DataValidation.*;

//The company has a maximum of 100 employees
// Each employee has a unique code
// use ArrayList to manage employees
// Demo data has at least 3 full-time employees and 2 part-time employees
public class Company {
    // ---------------------------Attributes---------------------------
    private ArrayList<FullTimeEmployee> fullTimeEmployees;
    private ArrayList<PartTimeEmployee> partTimeEmployees;
    //The company has a maximum of 100 employees
    private static final int MAX_EMPLOYEES = 100;
    // ---------------------------Constructors---------------------------
    // use ArrayList to manage employees

    // Demo data has at least 4 full-time employees and 6 part-time employees
    public Company() throws Exception {
        fullTimeEmployees = new ArrayList<>();
        partTimeEmployees = new ArrayList<>();
        FullTimeEmployee fullTimeEmployee1 = new FullTimeEmployee("FS00001", "Nguyen Van A", "0123456789", "Ha Noi", "IT", 2000, 0);
        FullTimeEmployee fullTimeEmployee2 = new FullTimeEmployee("FS00002", "Nguyen Van B", "0123456789", "Ha Noi", "IT", 2000, 0);
        FullTimeEmployee fullTimeEmployee3 = new FullTimeEmployee("FS00003", "Nguyen Van C", "0123456789", "Ha Noi", "IT", 2000, 0);
        FullTimeEmployee fullTimeEmployee4 = new FullTimeEmployee("FS00004", "Nguyen Van D", "0123456789", "Ha Noi", "IT", 2000, 0);
        createFullTimeEmployee(fullTimeEmployee1);
        createFullTimeEmployee(fullTimeEmployee2);
        createFullTimeEmployee(fullTimeEmployee3);
        createFullTimeEmployee(fullTimeEmployee4);

        PartTimeEmployee partTimeEmployee1 = new PartTimeEmployee("FS00005", "Nguyen Van E", "0123456789", "Ha Noi", "IT", 10, 1);
        PartTimeEmployee partTimeEmployee2 = new PartTimeEmployee("FS00006", "Nguyen Van F", "0123456789", "Ha Noi", "IT", 10, 1);
        PartTimeEmployee partTimeEmployee3 = new PartTimeEmployee("FS00007", "Nguyen Van G", "0123456789", "Ha Noi", "IT", 10, 1);
        PartTimeEmployee partTimeEmployee4 = new PartTimeEmployee("FS00008", "Nguyen Van H", "0123456789", "Ha Noi", "IT", 10, 1);
        PartTimeEmployee partTimeEmployee5 = new PartTimeEmployee("FS00009", "Nguyen Van I", "0123456789", "Ha Noi", "IT", 10, 1);
        PartTimeEmployee partTimeEmployee6 = new PartTimeEmployee("FS00010", "Nguyen Van J", "0123456789", "Ha Noi", "IT", 10, 1);
        createPartTimeEmployee(partTimeEmployee1);
        createPartTimeEmployee(partTimeEmployee2);
        createPartTimeEmployee(partTimeEmployee3);
        createPartTimeEmployee(partTimeEmployee4);
        createPartTimeEmployee(partTimeEmployee5);
        createPartTimeEmployee(partTimeEmployee6);
    }
    // ---------------------------Getters and Setter---------------------------
    public ArrayList<FullTimeEmployee> getFullTimeEmployees() {
        return fullTimeEmployees;
    }

    public void setFullTimeEmployees(ArrayList<FullTimeEmployee> fullTimeEmployees) {
        this.fullTimeEmployees = fullTimeEmployees;
    }

    public ArrayList<PartTimeEmployee> getPartTimeEmployees() {
        return partTimeEmployees;
    }

    public void setPartTimeEmployees(ArrayList<PartTimeEmployee> partTimeEmployees) {
        this.partTimeEmployees = partTimeEmployees;
    }
    // ---------------------------Methods---------------------------
    // Each employee has a unique code
    private boolean isExist(String code) {
        for (FullTimeEmployee fullTimeEmployee : fullTimeEmployees) {
            if (fullTimeEmployee.getCode().equals(code)) {
                return true;
            }
        }
        for (PartTimeEmployee partTimeEmployee : partTimeEmployees) {
            if (partTimeEmployee.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }
    // Create a new full-time employee
    public void createFullTimeEmployee(FullTimeEmployee fullTimeEmployee) throws Exception {
        // validate code
        if (isExist(fullTimeEmployee.getCode())) {
            throw new Exception("Code is exist.");
        }
        if (!isCode(fullTimeEmployee.getCode())) {
            throw new Exception("Code is invalid.");
        }
        // The company has a maximum of 100 employees
        if (fullTimeEmployees.size() + partTimeEmployees.size() >= MAX_EMPLOYEES) {
            throw new Exception("Full-time employees is full.");
        }
        // validate name
        if (!isName(fullTimeEmployee.getName())) {
            throw new Exception("Name is invalid.");
        }
        // validate phone
        if (!isPhoneNumber(fullTimeEmployee.getPhone())) {
            throw new Exception("Phone is invalid.");
        }
        // validate address
        if (!isAddress(fullTimeEmployee.getAddress())) {
            throw new Exception("Address is invalid.");
        }
        // validate department
        if (!isDepartment(fullTimeEmployee.getDepartment())) {
            throw new Exception("Department is invalid.");
        }
        // validate salary > 1500
        // Every day absent will be deducted 35
        if (fullTimeEmployee.getSalary() < 1500) {
            throw new Exception("Salary is invalid.");
        }
        fullTimeEmployee.setSalary(fullTimeEmployee.getSalary() - fullTimeEmployee.getAbsent() * 35);
        fullTimeEmployees.add(fullTimeEmployee);
    }

    // Create a new part-time employee
    public void createPartTimeEmployee(PartTimeEmployee partTimeEmployee) throws Exception {
        // validate code
        if (isExist(partTimeEmployee.getCode())) {
            throw new Exception("Code is exist.");
        }
        if (!isCode(partTimeEmployee.getCode())) {
            throw new Exception("Code is invalid.");
        }
        // The company has a maximum of 100 employees
        if (fullTimeEmployees.size() + partTimeEmployees.size() >= MAX_EMPLOYEES) {
            throw new Exception("Part-time employees is full.");
        }
        // validate name
        if (!isName(partTimeEmployee.getName())) {
            throw new Exception("Name is invalid.");
        }
        // validate phone
        if (!isPhoneNumber(partTimeEmployee.getPhone())) {
            throw new Exception("Phone is invalid.");
        }

        // validate address
        if (!isAddress(partTimeEmployee.getAddress())) {
            throw new Exception("Address is invalid.");
        }

        // validate department
        if (!isDepartment(partTimeEmployee.getDepartment())) {
            throw new Exception("Department is invalid.");
        }

        // validate daily wage > 10
        if (partTimeEmployee.getDailyWage() < 10) {
            throw new Exception("Daily wage is invalid.");
        }

        // validate present > 0
        if (partTimeEmployee.getPresent() <= 0) {
            throw new Exception("Present is invalid.");
        }

        partTimeEmployees.add(partTimeEmployee);
    }
    public void printFullTimeEmployees() {
        for (FullTimeEmployee fullTimeEmployee : fullTimeEmployees) {
            System.out.println(fullTimeEmployee);
        }
    }
    public void printPartTimeEmployees() {
        for (PartTimeEmployee partTimeEmployee : partTimeEmployees) {
            System.out.println(partTimeEmployee);
        }
    }

}
