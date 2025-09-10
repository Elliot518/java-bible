package zeus.infra.performance;

/**
 * Created by KG on 2017/7/22.
 */

public class TimeConsole implements TimeDevice {
    @Override
    public void print(String moduleName, String time, long seconds) {
        System.out.println("******************************* Performance Log *******************************");
        System.out.println("Module: " + moduleName + ", Time Consumed: " + time + ", 性能: " + WarnMsg.infoBySeconds(seconds));
        System.out.println("*******************************************************************************");
    }
}

