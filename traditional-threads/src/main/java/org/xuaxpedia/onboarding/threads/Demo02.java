package org.xuaxpedia.onboarding.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo02 {
  /* The ExecutorService is a higher-level API for managing threads in Java.
   * It provides a way to create and manage a pool of threads, and to submit tasks for execution.
   * The ExecutorService interface provides several methods for submitting tasks, including execute() and submit().
   * The execute() method is used to submit a Runnable task for execution, while the submit() method is used to submit
   * a Callable task that returns a result.
   * The ExecutorService also provides methods for shutting down the thread pool, such as shutdown() and shutdownNow(),
   * which can be used to gracefully or forcefully shut down the thread pool, respectively.
   * In the example below, we create a fixed thread pool with 2 threads and submit 4 tasks for execution.
   * The tasks will be executed in the order they were submitted, and the thread pool will manage the execution
   * of the tasks, ensuring that only 2 tasks are executed at a time. After all tasks have been submitted,
   * we call shutdown() to gracefully shut down the thread pool, allowing any currently executing tasks
   * to finish before shutting down the pool.
   */
  void main() {
    ExecutorService pool = Executors.newFixedThreadPool(2);

    pool.execute(new WorkTask(2000, "Task 1"));
    pool.execute(new WorkTask(1000, "Task 2"));
    pool.execute(new WorkTask(2000, "Task 3"));
    pool.execute(new WorkTask(1000, "Task 4"));
    pool.shutdown();
  }
}

class WorkTask implements Runnable {

  private final int sleepTime;
  private final String name;

  public WorkTask(int sleepTime, String name) {
    this.name = name;
    this.sleepTime = sleepTime;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(sleepTime);
      System.out.println(name + " - " + Thread.currentThread().getName());
    } catch(InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }
}
