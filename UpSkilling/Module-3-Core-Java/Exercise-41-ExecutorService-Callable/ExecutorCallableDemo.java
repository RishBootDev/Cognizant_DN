import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCallableDemo {

    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        List<Future<Integer>> futures =
                new ArrayList<>();

        for (int i = 1; i <= 5; i++) {

            int number = i;

            Callable<Integer> task = () -> {

                System.out.println(
                        "Task " + number
                        + " executed by "
                        + Thread.currentThread().getName()
                );

                return number * number;
            };

            Future<Integer> future =
                    executor.submit(task);

            futures.add(future);
        }

        System.out.println("\nResults:");

        for (Future<Integer> future : futures) {

            try {

                Integer result =
                        future.get();

                System.out.println(result);

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        executor.shutdown();
    }
}