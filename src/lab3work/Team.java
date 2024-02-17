package lab3work;

import java.util.ArrayList;
import java.util.Arrays;

public class Team {
    private final String teamName;
    private ArrayList<Employee> teamMembers = new ArrayList<>();


    public Team(String teamName, Employee[] teamMembers) {
        this.teamName = teamName;
        this.teamMembers.addAll(Arrays.asList(teamMembers));
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTeamMembersQty() {
            return teamMembers.size();

    }

    public void addTeamMember(Employee[] teamMembers) {
        this.teamMembers.addAll(Arrays.asList(teamMembers));
    }

    public String isTeamMember(Employee employee) {
        for (Employee e : teamMembers) {
            return (e.equals(employee)) ? getTeamName() : null;
        }
        return null;
    }

    public String toString(){
        String teamName = this.teamName + "\n";
        String teamMembers = "";
        for (Employee member : this.teamMembers){
            teamMembers += member + "\n";
        }
        return teamName + teamMembers;
    }

}

