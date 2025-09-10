package zeus.playground.util;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: AlgUtil
 * @Package zeus.playground.util
 * @Description: Algorithm Util
 * @date 2018/5/29 14:11
 */
public class AlgUtil {
    public static String getOddString(String source) {
        String dest = "";
        for (int i=0;i<source.length();i+=2) {
            dest += source.substring(i, i+1);
        }
        return dest;
    }

    public static String getFullOddString(String source) {
        String dest = "";
        for (int i=0;i<source.length();i+=2) {
            dest += source.substring(i, i+1);
        }
        dest = source + "->" + dest;
        return dest;
    }
}
