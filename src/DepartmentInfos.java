public record DepartmentInfos(int departmentId, String departmentName) {
    public DepartmentInfos {
        if (departmentId < 0) {
            throw new IllegalArgumentException("Department ID cannot be negative");
        }
        if (departmentName == null) {
            throw new IllegalArgumentException("Department name cannot be null");
        }
    }
}
