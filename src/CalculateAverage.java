import java.util.List;

public class CalculateAverage {

    private CalculateAverage() {
    }

    public static double calculateAvgAge(List<Person> people) {
        if (people == null || people.isEmpty()) {
            System.out.println("Warning: Empty list, returning 0.0");
            return 0.0;
        }

        double avg = people.stream()
                .mapToInt(Person::age)
                .average()
                .orElse(0.0); // Handles empty lists safely

        System.out.println("Average age: " + avg);
        return avg;
    }

    public static double calculateAvgAgeParallel(List<Person> people) {
        if (people == null || people.isEmpty()) {
            System.out.println("Warning: Empty list, returning 0.0");
            return 0.0;
        }

        double avg = people.parallelStream()
                .mapToInt(Person::age)
                .average()
                .orElse(0.0); // Handles empty lists safely

        System.out.println("Average age: " + avg);
        return avg;
    }
}
