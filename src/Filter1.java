import java.util.List;
import java.util.stream.Collectors;

public class Filter1 {

    public static List<Person> filterByAge(List<Person> people, int minAge) {
        return people.parallelStream()
                .filter(p -> p.age() >= minAge)
                .collect(Collectors.toList());
    }

    public static List<Person> filterByBirthPlace(List<Person> people, int departmentId) {
        return people.parallelStream()
                .filter(p -> p.departmentId() == departmentId)
                .collect(Collectors.toList());
    }

    public static List<Person> filterByLastName(List<Person> people, String lastName) {
        return people.parallelStream()
                .filter(p -> p.lastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    public static double calculateAvgAge(List<Person> people) {
        int sum = people.parallelStream()
                .mapToInt(Person::age)
                .sum();
        double avg = (double) sum / people.size();
        System.out.println("Average age: " + avg);
        return avg;
    }
}
