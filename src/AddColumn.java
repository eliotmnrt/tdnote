import java.util.List;
import java.util.stream.Collectors;

public class AddColumn {

    private static List<PersonWithCategory> peopleWithCategory;

    public static List<PersonWithCategory> addAgeCategory(List<Person> people) {
        return people.parallelStream()
                .map(p -> new PersonWithCategory(p.firstName(), p.lastName(), p.age(), p.departmentId(), ageCategory(p.age())))
                .collect(Collectors.toList());
    }

    private static AgeCategory ageCategory(int age) {
        if (age < 12) {
            return AgeCategory.CHILD;
        } else if (age < 20) {
            return AgeCategory.TEENAGER;
        } else if (age < 65) {
            return AgeCategory.ADULT;
        } else {
            return AgeCategory.ELDERLY;
        }
    }

    public static List<PersonWithCategory> getPeopleWithCategory() {
        return peopleWithCategory;
    }

    public static void setPeopleWithCategory(List<PersonWithCategory> peopleWithCategory) {
        AddColumn.peopleWithCategory = peopleWithCategory;
    }
}
