package lab3work;

import lab3work.Employee;

public class Developer extends Employee {

    private String[] skills;

    public Developer(String lastname, String firstname, int age, String sexEmployee, double salary, String[] skills) {
        super(lastname, firstname, age, sexEmployee, salary);
        this.skills = skills;

    }

    public void addDeveloperSkill(String skill){
        String skills = String.join(",", this.skills) + "," + skill;
        this.skills = skills.trim().split("\\s+,\\s+|,\\s+|\\s+,|,");
    }
    @Override
    public void setSalary(double salary) {
        super.setSalary(salary);
    }

    @Override
    public String toString() {
        String skillsToPrint = " {" + String.join(", ", this.skills)  + "}";
        return super.toString() + skillsToPrint;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }
}
