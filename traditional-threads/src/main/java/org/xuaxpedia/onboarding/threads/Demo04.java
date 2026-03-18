package org.xuaxpedia.onboarding.threads;

public class Demo04 {

  /**
   * In the example below, we demonstrate the new Thread API by creating a thread builder using the ofPlatform() method,
   * which allows us to create threads with specific properties and manage them more easily.
   * We create a thread builder with a specific name pattern and use it to start multiple threads that execute
   * the same task. The thread builder manages the creation and execution of the threads, allowing us to easily
   * create and manage multiple threads with the same properties.
   * We then observe the behavior of the threads and their names, which are generated based on the name pattern
   * we specified in the thread builder.
   */

  void main(){
    Thread.Builder builder = Thread.ofPlatform()
      .name("worker-",1);

    Thread t1 = builder.start(() -> work());
    Thread t2 = builder.start(() -> work());
    Thread t3 = builder.start(() -> work());
  }

  void work(){
    System.out.println(Thread.currentThread().getName());
  }

}
