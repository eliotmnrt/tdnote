import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;

public class ParallelFilter {

    static ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

    public static List<Person> filterByAge(List<Person> people, int minAge) {
        return forkJoinPool.invoke(new FilterTask(people, p -> p.age() >= minAge));
    }

    public static List<Person> filterByBirthPlace(List<Person> people, int departmentId) {
        return forkJoinPool.invoke(new FilterTask(people, p -> p.departmentId() == departmentId));
    }


    private static class FilterTask extends RecursiveTask<List<Person>> {

        private final List<Person> people;
        private final Predicate<Person> predicate;

        public FilterTask(List<Person> people, java.util.function.Predicate<Person> predicate) {
            this.people = people;
            this.predicate = predicate;
        }

        @Override
        protected List<Person> compute() {
            if (people.size() <= 1) {
                return predicate.test(people.get(0)) ?
                        new ArrayList<>(List.of(people.get(0))) :
                        new ArrayList<>();
            }

            int mid = people.size() / 2;
            FilterTask leftTask = new FilterTask(people.subList(0, mid), predicate);
            FilterTask rightTask = new FilterTask(people.subList(mid, people.size()), predicate);

            invokeAll(leftTask, rightTask);

            List<Person> leftResult = new ArrayList<>(leftTask.join());
            List<Person> rightResult = rightTask.join();

            leftResult.addAll(rightResult);
            return leftResult;
        }
    }
}

