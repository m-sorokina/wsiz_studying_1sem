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
                    case 2, 3 -> company.addEmployee(operationSelect);
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
        System.out.print("Enter company's name (press \"Enter\" to leave): ");
        String companyName = in.nextLine();

        if (companyName.isBlank()) return null;

        return new Company(companyName);
    }

    public static void addCompanyEmployees(Company company) {
        System.out.println("""
                Enter the company's employees in format {position (D or K) surname name age sex salary {skill1, skill2}}:
                (press "Enter" to enter the next employee)
                (press "Enter" on the empty row to end)\s""");

        Employee employee = createCompanyEmployee();
        while (employee != null) {
            if (!company.addEmployee(employee)) {
                System.out.println("The employee was not added");
            }
            employee = createCompanyEmployee();
        }
    }

    public static Employee createCompanyEmployee() {

        String str = in.nextLine();
        if (!str.isBlank()) {
            try {
                if (str.toUpperCase().trim().startsWith("D")) {
                    return new Developer(str);
                } else if (str.toUpperCase().trim().startsWith("M")) {
                    return new Manager(str);
                }
            } catch (Exception ignored) {
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

//    static void removeCompanyEmployee(ArrayList<Company> companies) {
//      System.out.print("To remove company's employee enter employee's company index and employee index in format 1,1: ");
//       String[] allIndexes = in.nextLine().split(",");
//        if (checkIndexOfCompany(Integer.parseInt(allIndexes[0]) - 1, companies)) {
//            companies.get(Integer.parseInt(allIndexes[0]) - 1).removeEmployee(Integer.parseInt(allIndexes[1]) - 1);
//      } else {
//          System.out.println("Such company was not found among the companies");
//        }
//    }

//    public void printCompanies(ArrayList<Company> companies) {
//        for (Company item : companies) {
//            System.out.println(item);
//        }
//    }
//
//
//    static void compare() {
//        Employee employee1 = new Employee();
//        Employee employee2 = new Employee();
//        System.out.println(employee1 == employee2);
//        System.out.println(employee1 == employee1);
//        System.out.println(employee1.equals(employee2));
//    }
//
//    public boolean checkIndexOfCompany(int index, ArrayList<Company> companies) {
//        return index >= 0 && index < companies.size();
//    }
}

//        compare();

//        ArrayList<Company> companies = new ArrayList<>();
//        Company company = createCompany();
//        while (company != null) {
//            companies.add(company);
//            System.out.println("Enter the company's employees in format {surname name age}: " +
//                    "\n (press \"Enter\" to enter the next employee) " +
//                    "\n (press \"Enter\" on the empty row to leave) ");
//            Employee employee = createEmployee();
//            while (employee != null) {
//              boolean employeeAdded = company.addEmployee(employee);
//                     if (!employeeAdded) {System.out.println("The employee was not added");}
//                employee = createEmployee();
//            }
//            company = createCompany();
//        }
//        printCompanies(companies);

//        removeCompanyEmployee(companies);

//        printCompanies(companies);

