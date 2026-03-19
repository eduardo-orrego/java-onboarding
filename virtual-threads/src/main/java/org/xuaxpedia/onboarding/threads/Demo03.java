package org.xuaxpedia.onboarding.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Demo03 {
  /**
   * In the example below, we create a ThreadFactory instance using the Thread.ofVirtual() method, which creates a
   * factory for virtual threads. We set the name of the threads created by the factory using the name() method,
   * which takes a prefix and a number to generate unique thread names. We then create a new executor using the
   * Executors.newThreadPerTaskExecutor() method, which creates a new executor that creates a new thread for each
   * task that is submitted to it. We submit three tasks to the executor using the submit() method, which takes a
   * Runnable task as an argument. Each task simulates some work by sleeping for a specified amount of time and
   * then printing the name of the thread that is executing the task. Finally, we use a try-with-resources statement
   * to ensure that the executor is properly shut down after all tasks have been submitted. The output in the console
   * shows the names of the threads as they execute their respective tasks, demonstrating the use of virtual threads
   * in Java 19 with a custom ThreadFactory.
   */
  void main() {
    ThreadFactory thread_factory = Thread.ofVirtual()
      .name("thread-virtual-", 0)
      .factory();

    try (var executor = Executors.newThreadPerTaskExecutor(thread_factory)) {
      executor.submit(() -> work(3000, "tv-1"));
      executor.submit(() -> work(1000, "tv-2"));
      executor.submit(() -> work(2000, "tv-3"));
    }
  }

  void work(int sleepTime, String name) {
    try {
      Thread.sleep(sleepTime);
      System.out.println("Virtual Thread Name : " + name + " - " + Thread.currentThread().getName());
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

}
