public record PersonWithCategory(String firstName, String lastName, int age, int departmentId, AgeCategory ageCategory) {
    public PersonWithCategory {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}
