package org.xuaxpedia.onboarding.threads;

import java.util.concurrent.Executors;

public class Demo02 {

  /**
   *  In the example below, we create a virtual thread executor using the Executors.newVirtualThreadPerTaskExecutor()
   *  method. This method creates a new executor that creates a new virtual thread for each task that is submitted to
   *  it. We then submit three tasks to the executor using the execute() method, which takes a Runnable task as an
   *  argument. Each task simulates some work by sleeping for a specified amount of time and then printing the name
   *  of the thread that is executing the task. Finally, we use a try-with-resources statement to ensure that the
   *  executor is properly shut down after all tasks have been submitted. The output in the console shows the names
   *  of the threads as they execute their respective tasks, demonstrating the use of virtual threads in Java 19.
   */
  void main() {

    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      executor.execute(() -> work(2000, "thread-1"));
      executor.execute(() -> work(1000, "thread-2"));
      executor.execute(() -> work(3000, "thread-3"));
    }

  }

  void work(int sleepTime, String threadName) {
    try {
      Thread.sleep(sleepTime);
      System.out.println(threadName + " - " + Thread.currentThread().getName());
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

}