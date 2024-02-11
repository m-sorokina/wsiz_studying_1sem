package lab3work;

import java.util.ArrayList;

public class Company {
    private final String companyName;
    private final ArrayList<Employee> employees;

    public Company(String companyName) {
        this.companyName = companyName;
        this.employees = new ArrayList<>();
    }

    public Company() {
        System.out.print("Enter company's name: ");
        this.companyName = Program.in.nextLine();
        this.employees = new ArrayList<>();
    }

    public boolean addEmployee(Employee employee) {
        if (employee != null && !ifEmployeeExists(employee)) {
            this.employees.add(employee);
            return true;
        }
        return false;
    }

    private boolean ifEmployeeExists(Employee employee) {
        for (Employee newEmployee : employees) {
            if (employee.equals(newEmployee)) {
                System.out.println("Such employee already exists in the company");
                return true;
            }
        }
        return false;
    }

    public boolean removeEmployee(int index) {
        if (checkIndexOfEmployee(index)) {
            employees.remove(index);
            return true;
        }
        return false;
    }

    public boolean checkIndexOfEmployee(int index) {
        return index >= 0 && index < employees.size();
    }

    public String toString() {

        String company = "Company \"" + companyName + "\":\n";
        int n = 0;
        for (Employee employee : employees)
            company += (++n + ". " + employee + "\n");

        return company;
    }
}
