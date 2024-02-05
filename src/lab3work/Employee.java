package lab3work;

public abstract class Employee {
    private final String lastname;
    private final String firstname;
    private final int age;
    private final Sex sexEmployee;
    private int salary;

    private String[] skills;

    public Employee() {

        System.out.println("Enter the company's employees in format {position (D or K) surname name age sex salary {skill1, skill2}}");
        String employee = Program.in.nextLine();
        String[] employeeToSplit = employee.substring(0,employee.indexOf("{")).split("\\s");
        this.lastname = employeeToSplit[1];
        this.firstname = employeeToSplit[2];
        this.age = Integer.parseInt(employeeToSplit[3]);
        this.sexEmployee = (employeeToSplit[4].toUpperCase().startsWith("M")) ? Sex.MALE : Sex.FEMALE;
        this.salary = Integer.parseInt(employeeToSplit[5]);
        this.skills = employee.substring(employee.indexOf("{") + 1, employee.length() - 1).trim().split("\\s+,\\s+|,\\s+|\\s+,|,");

//        this.lastname = Program.in.nextLine();
//
//        System.out.print("Enter employee's name: ");
//        this.firstname = Program.in.nextLine();
//
//        System.out.print("Enter employee's age: ");
//        this.age = Program.in.nextInt();
//        Program.in.nextLine();
//
//        System.out.print("Enter employee's sex: ");
//        this.sexEmployee = (Program.in.nextLine().toUpperCase().startsWith("M")) ? Sex.MALE : Sex.FEMALE;
//
//        System.out.print("Enter employee's salary: ");
//        this.salary = Program.in.nextInt();
//        Program.in.nextLine();
//
//        System.out.print("Enter employee's skills: ");
//        String str = Program.in.nextLine();
//        this.skills = str.trim().split("\\s+,\\s+|,\\s+|\\s+,|,");
//
}

    public Employee(String employee) {
        String[] employeeToSplit = employee.substring(0,employee.indexOf("{")).split("\\s");
        this.lastname = employeeToSplit[1];
        this.firstname = employeeToSplit[2];
        this.age = Integer.parseInt(employeeToSplit[3]);
        this.sexEmployee = (employeeToSplit[4].toUpperCase().startsWith("M")) ? Sex.MALE : Sex.FEMALE;
        this.salary = Integer.parseInt(employeeToSplit[5]);
        this.skills = employee.substring(employee.indexOf("{") + 1, employee.length() - 1).trim().split("\\s+,\\s+|,\\s+|\\s+,|,");
    }

    public String toString() {
        String skillsToPrint = "{" + String.join(", ", this.skills)  + "}";
        return String.join(" ", this.firstname,
                this.lastname,
                Integer.toString(this.age),
                (sexEmployee == Sex.MALE) ? "M" : "F",
                this.salary + "zl",
                skillsToPrint);
    }

    public boolean equals(Object object) {
        Employee employee = (Employee) object;

        return (employee != null && this.lastname.equalsIgnoreCase(employee.lastname)
                && this.firstname.equalsIgnoreCase(employee.firstname)
                && this.age == employee.age
                && this.sexEmployee == employee.sexEmployee);
    }

}
