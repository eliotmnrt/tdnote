import java.util.List;

public class Data {

    public Data() {
    }

    private List<Person> persons = List.of(
        new Person("John", "Doe", 25, 1),
        new Person("Jane", "Doe", 30, 2),
        new Person("Tom", "Smith", 35, 1),
        new Person("Alice", "Smith", 40, 2),
        new Person("Bob", "Brown", 45, 1),
        new Person("Charlie", "Brown", 50, 2),
        new Person("David", "White", 55, 1),
        new Person("Eve", "White", 60, 2),
        new Person("Frank", "Black", 65, 1),
        new Person("Grace", "Black", 70, 2)
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
