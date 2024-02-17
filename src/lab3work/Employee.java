package lab3work;

public abstract class Employee {
    private final String lastname;
    private final String firstname;
    private final int age;
    private final Sex sexEmployee;
    private double salary;

     public Employee(String lastname, String firstname, int age, String sexEmployee, double salary) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
        this.sexEmployee = (sexEmployee.toUpperCase().startsWith("M")) ? Sex.MALE : Sex.FEMALE;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public String toString() {
                return String.join(" ", this.firstname,
                this.lastname,
                Integer.toString(this.age),
                (sexEmployee == Sex.MALE) ? "M" : "F",
                "$" + this.salary );
    }

    public boolean equals(Object object) {
        Employee employee = (Employee) object;

        return (employee != null && this.lastname.equalsIgnoreCase(employee.lastname)
                && this.firstname.equalsIgnoreCase(employee.firstname)
                && this.age == employee.age
                && this.sexEmployee == employee.sexEmployee);
    }

}
