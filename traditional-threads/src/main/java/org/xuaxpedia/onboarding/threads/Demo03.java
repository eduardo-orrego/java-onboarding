package org.xuaxpedia.onboarding.threads;

public class Demo03 {

  /**
   * In Java 19, the Thread API was enhanced with new methods for creating and managing threads.
   * The new API includes methods for creating threads with specific properties, such as setting the thread name,
   * priority, and daemon status.
   * The new API also includes methods for managing thread groups and for creating threads that are automatically
   * managed by the Java runtime.
   * In the example below, we create two threads using the new Thread API.
   * The first thread is created using the ofPlatform() method,which creates a thread that is managed by
   * the platform's thread scheduler.
   * The second thread is created using the unstarted() method, which creates a thread that is not yet started.
   * We set the name of each thread using the name() method, and we define a Runnable job that simply prints
   * the name of the current thread. Finally, we start both threads and observe the output in the console, which
   * shows the names of the threads as they execute their respective jobs.
   */
  void main() {

    Thread.ofPlatform()
      .name("Thread-1")
      .start(() -> {
        try {
          Thread.sleep(2000);
          System.out.println("Example 1 - " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });

    Thread thread_2 = Thread.ofPlatform()
      .name("Thread-2")
      .unstarted(() -> {
        try {
          Thread.sleep(1000);
          System.out.println("Example 2 - " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });

    thread_2.start();

  }
}
