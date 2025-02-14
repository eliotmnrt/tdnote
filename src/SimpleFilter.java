import java.util.List;
import java.util.stream.Collectors;

public class SimpleFilter {

    public static List<Person> filterByAge(List<Person> people, int minAge) {
        return people.stream()
                .filter(p -> p.age() >= minAge)
                .collect(Collectors.toList());
    }

    public static List<Person> filterByBirthPlace(List<Person> people, int departmentId) {
        return people.stream()
                .filter(p -> p.departmentId() == departmentId)
                .collect(Collectors.toList());
    }

    public static List<Person> filterByLastName(List<Person> people, String lastName) {
        return people.stream()
                .filter(p -> p.lastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

}