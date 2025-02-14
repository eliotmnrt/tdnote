import java.util.List;

public class Data {

    public Data() {
    }

    //des personnes provenants de departements différents (1-95)
    private List<Person> persons = List.of(
            new Person("John", "Doe", 25, 1),
            new Person("Jane", "Doe", 30, 2),
            new Person("Alice", "Smith", 35, 3),
            new Person("Bob", "Brown", 40, 4),
            new Person("Charlie", "Brown", 45, 5),
            new Person("David", "Lee", 50, 6),
            new Person("Eve", "Williams", 55, 7),
            new Person("Frank", "Moore", 60, 8),
            new Person("Grace", "Taylor", 65, 9),
            new Person("Helen", "Anderson", 70, 10),
            new Person("Ivan", "Thomas", 75, 11),
            new Person("Julia", "Jackson", 80, 12),
            new Person("Kevin", "White", 85, 13),
            new Person("Linda", "Harris", 90, 14),
            new Person("Michael", "Martin", 95, 15),
            new Person("Nancy", "Thompson", 65, 16),
            new Person("Oscar", "Young", 84, 17),
            new Person("Pamela", "Allen", 15, 18),
            new Person("Quentin", "Hall", 24, 19),
            new Person("Rachel", "Adams", 78, 20),
            new Person("Steve", "Scott", 23, 21),
            new Person("Tina", "King", 10, 22),
            new Person("Umberto", "Wright", 41, 23),
            new Person("Victor", "Lopez", 12, 24),
            new Person("Wendy", "Green", 22, 25),
            new Person("Xavier", "Baker", 33, 26),
            new Person("Yvonne", "Gonzalez", 8, 27),
            new Person("Zack", "Evans", 32, 28),
            new Person("Albert", "Perez", 19, 29),
            new Person("Brenda", "Torres", 34, 30),
            new Person("Cedric", "Parker", 24, 31),
            new Person("Diana", "Morris", 26, 32),
            new Person("Eddie", "Wood", 45, 33),
            new Person("Fiona", "Ward", 46, 34),
            new Person("George", "Cole", 35, 35),
            new Person("Hannah", "Russell", 62, 36),
            new Person("Isaac", "Griffin", 25, 37),
            new Person("Jack", "Diaz", 20, 38),
            new Person("Kathy", "Hayes", 15, 39)
    );

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void removePerson(Person person) {
        persons.remove(person);
    }

    public void removePerson(int index) {
        persons.remove(index);
    }

    public Person getPerson(int index) {
        return persons.get(index);
    }

    public void clear() {
        persons.clear();
    }

    public int size() {
        return persons.size();
    }

    public boolean isEmpty() {
        return persons.isEmpty();
    }

    public boolean contains(Person person) {
        return persons.contains(person);
    }
}
