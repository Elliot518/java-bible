package zeus.concurrency.partition;

import zeus.infra.performance.PerformanceManager;
import zeus.infra.performance.TimeConsole;

import java.util.List;

/**
 * @Author: KG
 * @Description:
 * @Date: Created in 下午1:41 2018/1/24
 * @Modified by:
 */

public abstract class GenericPartitionListThreadWithPerf<T> extends Thread {
    private static Integer threadCount = 0;

    private int threadNum;
    private List<T> partitionList;

    public GenericPartitionListThreadWithPerf(int threadNum, List<T> partitionList) {
        this.threadNum = threadNum;
        this.partitionList = partitionList;
    }

    /**
     * Central method of the class
     */
    @Override
    public void run() {
        PerformanceManager perf = new PerformanceManager("GenericPartitionListThread", new TimeConsole());
        perf.start("GenericPartitionListThread");

        // business callback
        callback(partitionList);

        perf.stop();

        synchronized (this) {
            threadCount++;
            System.out.println("Thread Count: " + threadCount + ", partition size:" + partitionList.size());
        }

        if (threadCount == threadNum) {
            perf.printTime();
        }
    }

    /**
     * abstract business callback method
     */
    public abstract void callback(List<T> partitionList);
}




