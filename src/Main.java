import java.util.List;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        List<Person> people = data.getPersons();
        System.out.println("People:");
        people.forEach(System.out::println);
        System.out.println();

    }

    public static void flow1(List<Person> people) {
        System.out.println("People filtered by birth place:");
        List<Person> peopleFilteredByBirthPlace = Filter1.filterByBirthPlace(people, 2);
        peopleFilteredByBirthPlace.forEach(System.out::println);
        System.out.println();

        List<PersonWithCategory> peopleWithCategory = AddColumn.addAgeCategory(people);
        AddColumn.setPeopleWithCategory(peopleWithCategory);
        System.out.println("People with age category:");
        peopleWithCategory.forEach(System.out::println);
    }
}