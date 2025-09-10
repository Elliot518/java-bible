package zeus.infra.performance;

import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;

/**
 * Created by KG on 2017/7/22.
 */
@Slf4j
public class TimeLog implements TimeDevice {
    @Override
    public void print(String moduleName, String time, long seconds) {
        log.info("******************************* Performance Log *******************************");
        log.info("Module: " + moduleName + ", Time Consumed: " + time + ", 性能: " + WarnMsg.infoBySeconds(seconds));
        log.info("*******************************************************************************");
    }
}


