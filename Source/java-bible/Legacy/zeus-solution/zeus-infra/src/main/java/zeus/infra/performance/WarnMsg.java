package zeus.infra.performance;

/**
 * Created by KG on 2017/7/24.
 */

public class WarnMsg {
    public static String infoBySeconds(long seconds) {
        if (seconds < 1) {
            return "性能不错啊!";
        }

        if (seconds < 3) {
            return "还有优化的空间!";
        }

        if (seconds < 6) {
            return "性能不佳!";
        }

        if (seconds < 10) {
            return "性能很差!";
        }

        return "赶快重写代码吧!!";
    }
}
