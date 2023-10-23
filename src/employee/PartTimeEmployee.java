package employee;

public class PartTimeEmployee extends Employee {
    // ---------------------------Attributes---------------------------
    private int dailyWage;
    private int present;

    // ---------------------------Constructors---------------------------
    public PartTimeEmployee(String code, String name, String phone, String address, String department, int dailyWage, int present) {
        super(code, name, phone, address, department);
        this.dailyWage = dailyWage;
        this.present = present;
    }

    public PartTimeEmployee() {
    }
    // ---------------------------Getters and Setter---------------------------

    public int getDailyWage() {
        return dailyWage;
    }

    public void setDailyWage(int dailyWage) {
        this.dailyWage = dailyWage;
    }

    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    @Override
    public String toString() {
        //print employee's information (code, name, total salary)
        return "PartTimeEmployee{" +
                "code='" + getCode() + '\'' +
                ", name='" + getName() + '\'' +
                ", dailyWage=" + getDailyWage() +
                '}';
    }
}
