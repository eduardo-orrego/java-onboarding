package org.xuaxpedia.onboarding.threads;

public class Demo04 {

  /**
   * In the example below, we create a Thread.Builder instance using the ofPlatform() method, which creates a thread
   * that is managed by the platform's thread scheduler. We set the name of the thread using the name() method,
   * which takes a prefix and a number to generate unique thread names. We define a Runnable job that simply prints
   * the name of the current thread. Finally, we start multiple threads using the start() method of the Thread.Builder
   * instance, which creates and starts a new thread for each job. The output in the console shows the names
   * of the threads as they execute their respective jobs.
   */

  void main(){
    Thread.Builder builder = Thread.ofPlatform()
      .name("worker-",1);

    Runnable job = this::work;

    builder.start(job);
    builder.start(this::work);
    builder.start(job);
  }

  void work(){
    System.out.println(Thread.currentThread().getName());
  }

}
