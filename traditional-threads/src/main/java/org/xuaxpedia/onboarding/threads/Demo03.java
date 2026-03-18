package org.xuaxpedia.onboarding.threads;

public class Demo03 {

  /**
  * In Java 19, the Thread API was enhanced with new methods for creating and managing threads.
  * The new API includes methods for creating threads with specific properties, such as setting the thread name,
  * priority, and daemon status.
  * The new API also includes methods for managing thread groups and for creating threads that are automatically
  * managed by the Java runtime.
  * In the example below, we demonstrate the new Thread API by creating two threads with different properties
  * and starting them using the new methods provided by the Thread class.
  * The first thread is created using the ofPlatform() method, which creates a thread that is managed by
  * the Java runtime and has a default name.
  * The second thread is created using the unstarted() method, which creates a thread that is not yet started
  * and allows us to set the thread name before starting it. We then start both threads and observe their behavior.
  */
  void main() {

    Thread thread_1 = Thread.ofPlatform()
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
