import java.util.List;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        List<Person> people = data.getPersons();
        System.out.println("People:");
        people.forEach(System.out::println);
        System.out.println();

        if (args.length > 0 && args[0].equals("parallel")) {
            ParallelStream1(people);
            ParallelStream2(people);
        } else {
            Simpleflow1(people);
            Simpleflow2(people);
        }
    }

    public static void Simpleflow1(List<Person> people) {
        System.out.println("People filtered by birth place:");
        List<Person> peopleFilteredByBirthPlace = SimpleFilter.filterByBirthPlace(people, 2);
        peopleFilteredByBirthPlace.forEach(System.out::println);
        System.out.println();

        List<PersonWithCategory> peopleWithCategory = AddColumn.addAgeCategory(people);
        AddColumn.setPeopleWithCategory(peopleWithCategory);
        System.out.println("People with age category:");
        peopleWithCategory.forEach(System.out::println);
    }

    public static void Simpleflow2(List<Person> people) {
        System.out.println("People filtered by age:");
        List<Person> peopleFilteredByAge = SimpleFilter.filterByAge(people, 18);
        peopleFilteredByAge.forEach(System.out::println);
        System.out.println();

        DataBis dataBis = new DataBis();
        List<DepartmentInfos> departmentInfos = dataBis.getDepartmentInfos();

        Aggregation.aggregate(peopleFilteredByAge, departmentInfos);

        Aggregation.cleanStats();

        Aggregation.getStatsByDepartments().forEach(s -> {
            System.out.println("in department " + s.department() + " average age : " +s.averageAge());
        });

    }

    public static void ParallelStream1(List<Person> people) {
        System.out.println("People filtered by birth place:");
        List<Person> peopleFilteredByBirthPlace = ParallelFilter.filterByBirthPlace(people, 2);
        peopleFilteredByBirthPlace.forEach(System.out::println);
        System.out.println();

        List<PersonWithCategory> peopleWithCategory = AddColumn.addAgeCategoryParallel(people);
        AddColumn.setPeopleWithCategory(peopleWithCategory);
        System.out.println("People with age category:");
        peopleWithCategory.forEach(System.out::println);
    }

    public static void ParallelStream2(List<Person> people) {
        System.out.println("People filtered by age:");
        List<Person> peopleFilteredByAge = ParallelFilter.filterByAge(people, 18);
        peopleFilteredByAge.forEach(System.out::println);
        System.out.println();

        DataBis dataBis = new DataBis();
        List<DepartmentInfos> departmentInfos = dataBis.getDepartmentInfos();

        Aggregation.aggregateParallel(peopleFilteredByAge, departmentInfos);

        Aggregation.cleanStats();

        Aggregation.getStatsByDepartments().forEach(s -> {
            System.out.println("in department " + s.department() + " average age : " +s.averageAge());
        });

    }






}