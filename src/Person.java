public record Person(String firstName, String lastName, int age, int departmentId) {
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}
