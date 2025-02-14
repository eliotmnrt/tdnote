import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

public class Aggregation {

    static List<StatsByDepartment> statsByDepartments = new ArrayList<>();

    public static void aggregate(List<Person> persons, List<DepartmentInfos> departmentInfos) {
        departmentInfos.parallelStream().map(dep ->{
            System.out.println("People in department " + dep.departmentId() + ":");
            List<Person> peopleInDepartment = Filter1.filterByBirthPlace(persons, dep.departmentId());
            peopleInDepartment.forEach(System.out::println);
            int nbPersons = peopleInDepartment.size();

            double avgAge =  Filter1.calculateAvgAge(peopleInDepartment);
            return new StatsByDepartment(dep.departmentName(), dep.departmentId(), nbPersons, avgAge);
        }).forEach(Aggregation::addStats);
    }

    public static void addStats(StatsByDepartment stats) {
        statsByDepartments.add(stats);
    }

    public static void cleanStats() {
        statsByDepartments.removeIf(stats -> stats.numberOfPeople() == 0);
    }

    public static List<StatsByDepartment> getStatsByDepartments() {
        return statsByDepartments;
    }
}
