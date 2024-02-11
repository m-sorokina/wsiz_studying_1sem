package lab3work;

import java.util.Scanner;

public class Program {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        Company company = createCompany();
        if (company != null) {
            int operationSelect = callMenu();
            while (operationSelect != 9) {
                in.nextLine();
                switch (operationSelect) {
                    case 1 -> addCompanyEmployees(company);
                    case 2 -> {
                        System.out.println("Enter a developer in format {surname name age sex salary {skill1, skill2}}");
                        company.addEmployee(addCompanyEmployee(Position.DEVELOPER));
                    }
                    case 3 -> {
                        System.out.println("Enter a developer in format {surname name age sex salary}");
                        company.addEmployee(addCompanyEmployee(Position.MANAGER));
                    }
                    case 4 -> removeCompanyEmployee(company);
                    default -> System.out.println("Operation with such number doesn't exist");
                }
                System.out.println(company);
                operationSelect = callMenu();
            }
        } else {
            System.out.println("There is no company to which employees could be added or removed from");
        }

    }

    public static int callMenu() {

        System.out.println("""
                                
                Select operation:
                1 - enter list of company employees
                2 - add developer
                3 - add manager
                4 - remove employee
                9 - end the program
                                
                Enter the operation number:\s""");

        return in.nextInt();
    }


    public static Company createCompany() {
        System.out.print("Enter company's name (press \"Enter\" to end): ");
        String companyName = in.nextLine();

        if (companyName.isBlank()) return null;

        return new Company(companyName);
    }

    public static void addCompanyEmployees(Company company) {
        System.out.println("""
                Enter list of company's employees:
                (press "Enter" to enter the next employee)
                (press "Enter" on the empty row to end)\s""");

        Position employeePosition = selectEmployeePosition();

        Employee employee = addCompanyEmployee(employeePosition);
        while (employee != null) {
            if (!company.addEmployee(employee)) {
                System.out.println("The employee was not added");
            }
            employee = addCompanyEmployee(employeePosition);
        }
    }

    public static Position selectEmployeePosition() {
        System.out.println("""
                Select the employee's position:
                1. Manager
                2. Developer\s""");

        Position position = null;
        int operationNumber = in.nextInt();
        while (position == null) {
            switch (operationNumber) {
                case 1 -> {
                    position = Position.MANAGER;
                    System.out.println("Enter a manager in format {surname name age sex salary}");
                }
                case 2 -> {
                    position = Position.DEVELOPER;
                    System.out.println("Enter a developer in format {surname name age sex salary {skill1, skill2}}");
                }
                default -> System.out.println("The entered position doesn't exist, please select correct position");
            }
        }
        in.nextLine();
        return position;
    }

    public static Employee addCompanyEmployee(Position position) {
        String str = in.nextLine();
        if (!str.isBlank()) {
            try {
                String[] employeeToSplit = (str.contains("{")) ? str.substring(0, str.indexOf("{")).split("\\s") : str.split("\\s");
                String lastname = employeeToSplit[0].trim();
                String firstname = employeeToSplit[1].trim();
                int age = Integer.parseInt(employeeToSplit[2].trim());
                String sexEmployee = employeeToSplit[3].trim();
                double salary = Double.parseDouble(employeeToSplit[4].trim());
                if (position == Position.DEVELOPER) {
                    String[] skills = str.substring(str.indexOf("{") + 1, str.length() - 1).trim().split("\\s+,\\s+|,\\s+|\\s+,|,");
                    return new Developer(lastname, firstname, age, sexEmployee, salary, skills);
                } else if (position == Position.MANAGER) {
                    return new Manager(lastname, firstname, age, sexEmployee, salary);
                }
            } catch (Exception ignore) {
                System.out.println("Some needed fields are missing or incorrect\nThe employee was not added");
            }
        }
        return null;
    }


    public static void removeCompanyEmployee(Company company) {
        System.out.print("To remove company's employee enter employee's index: ");
        if (!company.removeEmployee(Integer.parseInt(in.nextLine()) - 1)) {
            System.out.println("The employee with such index was not found");
        }

    }

}
