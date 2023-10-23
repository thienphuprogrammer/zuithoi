package employee;

public class FullTimeEmployee extends Employee {
    // ---------------------------Attributes---------------------------
    private double salary;
    private int absent;

    // ---------------------------Constructors---------------------------
    public FullTimeEmployee(String code, String name, String phone, String address, String department, double salary, int absent) {
        super(code, name, phone, address, department);
        this.salary = salary;
        this.absent = absent;
    }

    public FullTimeEmployee() {
    }
    // ---------------------------Getters and Setter---------------------------

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

    @Override
    public String toString() {
        //print employee's information (code, name, total salary)
        return "FullTimeEmployee{" +
                "code='" + getCode() + '\'' +
                ", name='" + getName() + '\'' +
                ", salary=" + salary +
                '}';
    }
}
