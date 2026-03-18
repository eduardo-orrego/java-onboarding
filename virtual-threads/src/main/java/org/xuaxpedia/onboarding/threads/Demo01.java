package org.xuaxpedia.onboarding.threads;

public class Demo01 {
  /**
   * In Java 19, the Thread API was enhanced with new methods for creating and managing threads.
   * The new API includes methods for creating threads with specific properties, such as setting the thread name,
   * In the example below, we create three threads using the new Thread API. The first thread is created using the
   * ofVirtual() method, which creates a virtual thread that is managed by the Java runtime. The second thread
   * is created using a Thread.Builder instance, which allows us to set properties such as the thread name before
   * starting the thread. The third thread is created using the unstarted() method, which creates a thread that
   * is not yet started. We set the name of each thread using the name() method, and we define a Runnable job that
   * simply prints the name of the current thread. Finally, we start all three threads and observe the output
   * in the console, which shows the names of the threads as they execute their respective jobs.
   */
  void main() {
    Thread thread_1 = Thread.ofVirtual()
      .name("thread")
      .start(() -> {
        try {
          Thread.sleep(1000);
          System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      });

    Thread.Builder builder = Thread.ofVirtual()
      .name("thread-builder");

    Thread thread_2 = builder.start(() -> {
      try {
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    Thread thread_3 = Thread.ofVirtual()
      .name("thread-manual")
      .unstarted(() -> System.out.println(Thread.currentThread().getName()));

    try {
      thread_1.join();
      thread_2.join();
      thread_3.start();
      thread_3.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }


  }
}
