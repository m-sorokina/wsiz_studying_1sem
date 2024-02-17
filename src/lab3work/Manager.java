package lab3work;

import lab3work.Employee;

public class Manager extends Employee {

    public Manager(String lastname, String firstname, int age, String sexEmployee, double salary) {
        super(lastname, firstname, age, sexEmployee, salary);
    }
    @Override
    public void setSalary(double salary) {
        super.setSalary(salary);
    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }
}
