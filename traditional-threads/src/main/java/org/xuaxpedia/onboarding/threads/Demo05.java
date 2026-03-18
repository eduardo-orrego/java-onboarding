package org.xuaxpedia.onboarding.threads;

public class Demo05 {
  /**
   * In the example below, we create a counter class that has a synchronized method for incrementing a value
   * and a synchronized method for retrieving the current value. We create two threads that both increment
   * the counter 1000 times. Since the increment() method is synchronized, it ensures that only one thread
   * can access it at a time and prevents race conditions. After both threads have completed their execution,
   * we retrieve and print the final value of the counter, which should be 2000, demonstrating that the
   * synchronized methods have successfully prevented any race conditions and ensured the correct behavior
   * of the counter in a multithreaded environment.
   */
  void main() {
    counter c = new counter();

    Thread.Builder builder = Thread.ofPlatform()
      .name("worker-",1);

    Runnable job = () -> {
      for (int i = 0; i < 1000; i++) {
        c.increment();
      }

    };

    Thread thread_1 = builder.unstarted(job);
    Thread thread_2 = builder.unstarted(job);

    thread_1.start();
    thread_2.start();

    try {
      thread_1.join();
      thread_2.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    System.out.println("Final value: " + c.getValue());
  }

}

class counter {
  private int value = 0;

  public synchronized void increment() {
    value++;
  }

  public synchronized int getValue() {
    return value;
  }
}
