package zeus.test.concurrency.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SimpleBlockingQueueTest
{
   public static void main(String[] args)
   {
      final int FILE_QUEUE_SIZE = 10;
      final int SEARCH_THREADS = 100;
      
      BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(FILE_QUEUE_SIZE);

      for (int i = 1; i <= SEARCH_THREADS; i++)
         new Thread(new SimpleTask(queue, i)).start();
   }
}

class SimpleTask implements Runnable
{
   public SimpleTask(BlockingQueue<Integer> queue, Integer seqNo)
   {
      this.queue = queue;
      this.seqNo = seqNo;
   }

   public void run()
   {
      try {
         queue.put(seqNo);
         Thread.sleep(1000);
         Integer elem = queue.take();
         System.out.printf("Element No.%d from the blocking queue.\n", elem);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   private BlockingQueue<Integer> queue;
   private Integer seqNo;
}
