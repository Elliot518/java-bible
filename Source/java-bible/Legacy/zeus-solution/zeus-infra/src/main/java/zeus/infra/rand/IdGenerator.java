package zeus.infra.rand;

import java.util.Random;

/**
 * Created by KG on 2017/4/25.
 */
public class IdGenerator {
    // length是随机字符串长度，strs为随机种子字符串数组，传空值则默认0-9混合大小写字母
    public static String getRandomString(int length) {
        String[] strs = new String[] { "0123456789", "abcdefghijklmnopqrstuvwxyz",
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZ" };

        Random random = new Random();

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++) {
            int choice = random.nextInt(strs.length);
            String str = strs[choice];
            int rn = random.nextInt(str.length());
            sb.append(str.charAt(rn));
        }

        return sb.toString();
    }
}
