package org.xuaxpedia.onboarding.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Demo04 {
  /**
   * In the example below, we create a Semaphore instance with a specified number of permits, which limits the number
   * of threads that can access a shared resource concurrently. We then create a virtual thread executor using the
   * Executors.newVirtualThreadPerTaskExecutor() method and submit several tasks to the executor using the execute()
   * method. Each task simulates some work by sleeping for a specified amount of time and then printing the name of
   * the thread that is executing the task. Before accessing the shared resource, each task acquires a permit from
   * the semaphore using the acquire() method, which blocks if there are no permits available. After accessing the
   * shared resource, each task releases the permit using the release() method, allowing other threads to acquire it.
   * Finally, we use a try-with-resources statement to ensure that the executor is properly shut down after all tasks
   * have been submitted. The output in the console shows the names of the threads as they execute their respective
   * tasks, demonstrating how to use a semaphore to limit concurrent access to a shared resource in Java 19 with
   * virtual threads.
   * git commit -m "Add Demo04 class to demonstrate the use of Semaphore with virtual threads and update Demo03
   */
  void main() {

    int MAX_CONCURRENT = 2;

    Semaphore limit = new Semaphore(MAX_CONCURRENT);

    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      executor.execute(() -> work("thread-1", limit, 2000));
      executor.execute(() -> work("thread-2", limit, 3000));
      executor.execute(() -> work("thread-3", limit, 4000));
      executor.execute(() -> work("thread-4", limit, 1000));

    }
  }

  void work(String name, Semaphore semaphore, int SleepTime) {
    try {
      semaphore.acquire();

      System.out.println("START " + name);

      Thread.sleep(SleepTime);

      System.out.println("END " + name);

    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    } finally {
      semaphore.release();
    }
  }

}
