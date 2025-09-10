package zeus.infra.performance;

/**
 * Created by KG on 2017/7/22.
 */

public class PerformanceManager {
    private String moduleName;

    private long startTime;
    private long endTime;
    private StopWatch watch;
    private TimeDevice timeDevice;

    public PerformanceManager(String moduleName, TimeDevice timeDevice) {
        this.moduleName = moduleName;
        this.timeDevice = timeDevice;
        this.watch = new StopWatch();
    }

    public StopWatch getWatch() {
        return watch;
    }

    public void setWatch(StopWatch watch) {
        this.watch = watch;
    }

    public TimeDevice getTimeDevice() {
        return timeDevice;
    }

    public void setTimeDevice(TimeDevice timeDevice) {
        this.timeDevice = timeDevice;
    }

    public void start(String moduleName) {
        watch.start();
        startTime = watch.getStartTime();
        this.moduleName = moduleName;
    }

    public void stop() {
        watch.stop();
        endTime = watch.getStopTime();
    }

    public void printTime() {
        timeDevice.print(moduleName, watch.getTimeString(), watch.getSeconds());
    }
}
