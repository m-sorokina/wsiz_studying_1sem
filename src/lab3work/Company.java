package lab3work;

import java.util.ArrayList;

public class Company {
    private final String companyName;
    private final ArrayList<Employee> employees;
    private final ConsoleLogger logger;
    private final ArrayList<Team> teams;

    public Company(String companyName) {
        this.companyName = companyName;
        employees = new ArrayList<>();
        logger = new ConsoleLogger(null);
        teams = new ArrayList<>();
    }

    public Employee getCompanyEmployee(int index) {
        return employees.get(index);
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public boolean addEmployee(Employee employee) {
        if (employee != null)
            if (!ifEmployeeExists(employee)) {
                this.employees.add(employee);
                logger.info("the employee is added: " + employee);
                return true;
            } else {
                logger.error("an attempt to add an existing employee: " + employee);
            }
        return false;
    }

    private boolean ifEmployeeExists(Employee employee) {
        for (Employee newEmployee : employees) {
            if (employee.equals(newEmployee)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeEmployee(int index) {
        if (checkIndexOfEmployee(index)) {
            Employee employee = employees.remove(index);
            logger.info("the employee is removed: " + employee.toString());
            return true;
        }
        logger.error("an attempt to remove an employee with index which doesn't exist: " + index);
        return false;
    }

    public boolean changeEmployeeSalary(int index, double salary) {
        if (checkIndexOfEmployee(index)) {
            Employee employee = employees.get(index);
            employee.setSalary(salary);
            return true;
        }
        return false;
    }

    public boolean addEmployeeSkills(int index, String skill) {
        if (checkIndexOfEmployee(index)) {
            Developer employee = (Developer) employees.get(index);
            employee.addDeveloperSkill(skill);
            return true;
        }
        return false;
    }

    public void addEmployeeToTeam(String teamName, int[] teamMembersIndexes) {
        Employee[] teamMembers = createEmployeeList(teamMembersIndexes);
        Team team = findOrCreateTeam(teamName);
        team.addTeamMember(teamMembers);
    }

    private Employee[] createEmployeeList(int[] teamMembersIndexes) {
        Employee[] teamMembers = new Employee[teamMembersIndexes.length];
        for (int i = 0; i < employees.size(); i++) {
            for (int j = 0; j < teamMembersIndexes.length; j++)
                if (teamMembersIndexes[j] == i) {
                    teamMembers[j] = employees.get(teamMembersIndexes[j]);
                }
        }
        return teamMembers;
    }

    public Team findOrCreateTeam(String teamName) {
        Team team = checkIfTeamExist(teamName);
        if (team == null) {
            team = new Team(teamName);
            teams.add(team);
        }
        return team;
    }

    public Team checkIfTeamExist(String teamName) {
        for (Team team : teams) {
            if (team.getTeamName().equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        return null;
    }

    public boolean checkIndexOfEmployee(int index) {

        return index >= 0 && index < employees.size();
    }

    public String toString() {

        String company = "\nCompany \"" + companyName + "\":\n";
        int nManagers = 0;
        int nDevelopers = 0;
        String managers = "Managers:\n";
        String developers = "Developers:\n";
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                managers += (++nManagers + ". " + employee + " (" + (employees.indexOf(employee) + 1) + ")\n");
            } else if (employee instanceof Developer) {
                developers += (++nDevelopers + ". " + employee + " (" + (employees.indexOf(employee) + 1) + ")\n");
            }
        }
        company = company + managers + developers;

        return company;
    }

    public void printCompanyEmployees() {
        String company = "\nCompany \"" + companyName + "\":\n";
        int n = 0;
        System.out.printf("%s%n%8s%2s%10s%3s%34s%26s%6s%4s%8s%2s%10s%2s%8s%n",
                company, "Number", "|", "Position", "|", "Employee", "|",
                "Team", "|", "Salary", "|", "Team size", "|", "Index |");
        System.out.printf("%s%n", "-".repeat(123));
        for (Employee employee : employees) {
            String teamSize = "";
            String teamName = "";
            if (employee.getTeam() != 0) {
                teamName = getTeamName(employee.getTeam());
                if (employee.getPosition() == Position.MANAGER) {
                    teamSize = String.valueOf(((Manager) employee).getTeamSize());
                }
            }
            System.out.printf("%5d\t%2s%-10s%3s%-58s%2s%8s%2s%8.1f%2s%6s%6s%4s%4s%n", ++n,
                    "|", employee.getPosition(), "|", employee, "|", teamName, "|", employee.getTotalSalary(), "|", teamSize, "|",
                    (employees.indexOf(employee) + 1), "|");
        }

    }

    public String getTeamName(int ID) {
        for (Team team : teams) {
            if (team.getID() == ID) {
                return team.getTeamName();
            }
        }
        return null;
    }
}
