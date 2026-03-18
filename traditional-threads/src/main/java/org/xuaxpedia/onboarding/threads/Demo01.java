package org.xuaxpedia.onboarding.threads;

public class Demo01 {
  /**
   * Threads in Java can be created by implementing the Runnable interface or by extending the Thread class.
   * The Runnable interface is a functional interface that has a single method, run(),
   * which contains the code that will be executed by the thread.
   * To create a thread using the Runnable interface, you can create a class that implements the Runnable interface
   * and override the run() method.
   * Then, you can create an instance of the Thread class and pass an instance of your Runnable class to the
   * Thread constructor. Finally, you can start the thread by calling the start() method on the Thread instance.
   * In Java 8 and later versions, you can also use lambda expressions to create threads more concisely.
   * Instead of creating a separate class that implements the Runnable interface, you can directly pass
   * a lambda expression to the Thread constructor, which will be executed when the thread is started.
   * This can make your code more concise and easier to read, especially for simple tasks that can be expressed
   * in a single line of code.
   * In the example below, we demonstrate both approaches for creating threads in Java, using an external class
   * that implements the Runnable interface and using lambda expressions to create threads directly
   * in the Thread constructor.
   */

  void main() {

    //Since java 1.0

    //Example 1 - Implementing Runnable interface with external class
    Thread thread_1 = new Thread(new MyWork());

    //Example 2 - Implementing Runnable interface with anonymous call
    Runnable runnable_anonymous = new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
          System.out.println("Example 2 - " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    Thread thread_2 = new Thread(runnable_anonymous);

    //Since java 1.8 - Lambdas simplifican Runnable

    //Example 3 - Implementing a Runnable interface with lambdas
    Runnable runnable_lambda = () -> {
      try {
        Thread.sleep(3000);
        System.out.println("Example 3 - " + Thread.currentThread().getName());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };

    Thread thread_3 = new Thread(runnable_lambda);

    //Example 4 - Implementing Runnable interface with lambdas directly in the Thread constructor
    Thread thread_4 = new Thread(() -> {
      try {
        Thread.sleep(2000);
        System.out.println("Example 4 - " + Thread.currentThread().getName());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    thread_1.start();
    thread_2.start();
    thread_3.start();
    thread_4.start();

  }
}

class MyWork implements Runnable {
  @Override
  public void run() {
      try {
        Thread.sleep(5000);
        System.out.println("Example 1 - " + Thread.currentThread().getName());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
  }
}
